<template>
  <div style="height: 750px;">
    <div style="display: flex;justify-content: end;align-items: center">
      <el-button @click="uploadVisible=true">
        <el-icon>
          <Plus/>
        </el-icon>
      </el-button>
    </div>
    <el-dialog
        v-model="uploadVisible"
        title="上传照片"
        class="upload"
        @close="uploadVisible = false"
    >
      <el-form>
        <el-form-item label="相册类别" label-width="80px">
          <el-text>
            {{ store.state.albumCategory }}
          </el-text>
        </el-form-item>
        <el-form-item label="相册名称" label-width="80px">
          <el-text>{{ store.state.albumName }}</el-text>
        </el-form-item>
        <el-form-item label="照片名称" label-width="80px">
          <el-input v-model="photoName" placeholder="请输入照片名称"></el-input>
        </el-form-item>
        <el-form-item label="照片描述" label-width="80px">
          <el-input v-model="photoDescription" placeholder="请输入照片描述"></el-input>
        </el-form-item>
        <el-form-item label="照片" label-width="80px">
          <el-upload
              :class="{hide_box:upload_btn}"
              ref="uploadRef"
              action="http://localhost:8080/api/photo/addPhoto"
              list-type="picture-card"
              :limit="1"
              :data="photo"
              :auto-upload="false"
              :on-success="handleSuccess"
          >
            <el-icon>
              <Plus/>
            </el-icon>
          </el-upload>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button size="small" type="primary" @click="submitUpload">确 定</el-button>
      </template>
    </el-dialog>
    <el-scrollbar>
      <div class="photos">
        <div v-for="photo in store.state.selectedAlbum"
             :key="photo" :class="'photo'" style="width: 100%;">
          <div style="display: flex">
            <div class="photo-image" style="width: 60%">
              <div>
                <el-image :src="photo.photoUrl" style="width: 100%;height: 200px"
                          :preview-src-list="photoUrlList"></el-image>
              </div>
              <div style="height: 50px;display: flex;justify-content: space-evenly;align-items: center;">
            <span>
              {{ photo.photoName }}
            </span>
              </div>
              <!--        todo  照片功能按钮-->
              <div style="display:flex;justify-content: center">
                <el-button text @click="editDescription(photo)">
                  <el-icon>
                    <Edit/>
                  </el-icon>
                </el-button>
                <el-button text @click="deletePhotoDialog(photo)">
                  <el-icon>
                    <DeleteFilled/>
                  </el-icon>
                </el-button>
              </div>
            </div>
            <div style="width: 40%;display:flex;justify-content: center;align-items: center;">
              {{ photo.photoDescription }}
            </div>
          </div>
          <div class="photo-comment" style="height: 200px;display:flex;justify-content: center;">
            <el-scrollbar>
              <div>
                <div class="comments" v-for="comment in photo.comments">
                  {{ comment.commentContent }}
                </div>
              </div>
              <div>
                <el-input v-model="newComment" type="text" placeholder="请输入评论内容"
                          style="width: 200px;"></el-input>
                <el-button type="text" @click="addComment(photo)">评论</el-button>
              </div>
            </el-scrollbar>
          </div>
        </div>

      </div>

    </el-scrollbar>
  </div>
</template>
<script lang="ts" setup>

import {DeleteFilled, Edit, Plus} from '@element-plus/icons-vue'
import {useStore} from "vuex";
import {ElMessageBox, UploadInstance} from "element-plus";
import {onMounted, reactive, ref, watch} from "vue";
import api from "@/api/api";

const store = useStore()
const uploadVisible = ref(false)
const upload_btn = ref(false)
//上传照片 todo
const uploadRef = ref<UploadInstance>()
const handleSuccess = async (res, file) => {
  console.log(photo)
  console.log(file)
  // 上传成功后，将上传按钮隐藏
  upload_btn.value = true
  location.reload()
}


//上传提交
const submitUpload = () => {
  uploadRef.value!.submit()
  uploadVisible.value = false
}

const photoName = ref('')
const photoDescription = ref('')
const photo = {
  photoId: null,
  albumId: 1,
  photoName: photoName.value,
  photoDescription: photoDescription.value,
  isCover: true,
  userId: 1,
  photoUrl: "",
  adminId: 1
}


let photos = reactive([])
let photoUrlList = reactive([])
onMounted(async () => {
  //根据路径获取相册id http://localhost:5173/album/xx/xxx xxx为相册类别，xxx为相册名称

  //在localStorage中存储的相册类别列表中查找到对应的相册类别
  const albumCategoryList = JSON.parse(localStorage.getItem('albumCategoryList'))
  // 获取当前 URL 中的路径
  const currentPath = window.location.pathname;
  // 定义匹配路径的正则表达式
  const regex = /\/album\/([^/]+)\/([^/]+)/;
  // 使用正则表达式进行匹配
  const match = currentPath.match(regex);
  console.log(match)
  if (match) {
    var albumCategoryName = decodeURIComponent(match[1]);
    var albumName = decodeURIComponent(match[2]);
    const albumCategory = albumCategoryList.find(item => item["categoryName"] === albumCategoryName);
    var categoryId = albumCategory.categoryId;
    const albumList = JSON.parse(localStorage.getItem('albumList' + categoryId))
    const album = albumList.find(item => item.albumName === albumName);
    var albumId = album.albumId;
    const res = await api.getPhotoByAlbumId(albumId)
    console.log(res.data)
    for (let i = 0; i < res.data.length; i++) {
      photos.push({
        photoId: res.data[i].photoId,
        albumId: res.data[i].albumId,
        photoName: res.data[i].photoName,
        photoDescription: res.data[i].photoDescription,
        isCover: res.data[i].cover,
        userId: res.data[i].userId,
        photoUrl: res.data[i].photoUrl,
        adminId: res.data[i].adminId,
        comments: res.data[i].comments
      })

      photoUrlList.push(res.data[i].photoUrl)

    }
    console.log(photos)
    localStorage.setItem('selectedAlbum', JSON.stringify(photos))
    store.commit('setSelectedAlbumCategory', albumCategory.categoryPath)
    store.commit('setAlbumName', albumName)
    store.commit('setAlbumCategory', albumCategory.categoryName)
    store.commit('setSelectedAlbum', photos)
  }


})

const deletePhotoDialog = (photo) => {
  console.log(photo)
  ElMessageBox.confirm('此操作将永久删除该照片, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    console.log(photo.photoId)
    const res = await api.deletePhoto(photo.photoId)
    console.log(res)
    if (res.data.code === 200) {
      await ElMessageBox.alert('删除成功', '提示', {
        confirmButtonText: '确定',
        callback: () => {
          //刷新页面
          location.reload()
          //删除后重新获取相册列表

        }
      })
    }
  })
}

const editDescription = (photo) => {
  ElMessageBox.prompt('请输入照片描述', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    inputValue: photo.photoDescription,
    inputPlaceholder: '请输入照片描述'
  }).then(async ({value}) => {
    console.log(value)
    const res = await api.updatePhotoDescription(photo.photoId, value)
    console.log(res)
    if (res.data.code === 200) {
      await ElMessageBox.alert('修改成功', '提示', {
        confirmButtonText: '确定',
        callback: () => {
          //刷新页面
          location.reload()
          //删除后重新获取相册列表

        }
      })
    }
  })
}


const newComment = ref('')

const addComment = async (photo) => {
  console.log(photo.photoId)
  console.log(newComment.value)
  if (newComment.value === '') {
    await ElMessageBox.alert('评论内容不能为空', '提示', {
      confirmButtonText: '确定',
      callback: () => {
        //刷新页面
        location.reload()
        //删除后重新获取相册列表
      }
    })
    return
  } else {
    const res = await api.addComment(photo.photoId, newComment.value)
    console.log(res)
    if (res.data.code === 200) {
      await ElMessageBox.alert('评论成功', '提示', {
        confirmButtonText: '确定',
        callback: () => {
          //刷新页面
          location.reload()
          //删除后重新获取相册列表
        }
      })
      newComment.value = ''
    }
  }
}


</script>
<style scoped lang="less">

.photos {
  display: flex;
  flex-wrap: wrap;

}

.upload-photo {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.hide_box :deep(.el-upload--picture-card) {
  display: none;
}
</style>