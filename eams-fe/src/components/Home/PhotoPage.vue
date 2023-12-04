<template>
  <div :class="store.state.selectedAlbum.category+store.state.selectedAlbum.title" style="height: 750px;">
    <div style="display: flex;justify-content: end;align-items: center">
      <el-button @click="uploadVisible=true">
        <el-icon>
          <Plus/>
        </el-icon>
      </el-button>
      <el-button>
        <el-icon>
          <Sort/>
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
            {{ store.state.albumCategory.find(item => item.path === store.state.selectedAlbumCategory)?.title }}
          </el-text>
        </el-form-item>
        <el-form-item label="相册名称" label-width="80px">
          <el-text>{{ store.state.selectedAlbum.title }}</el-text>
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
              action="#"
              list-type="picture-card"
              :auto-upload="false"
              :limit="1"
              :on-change="handleSuccess"
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
        <div v-for="photo in store.state.selectedAlbum.photos"
             :key="photo" :class="'photo'" style="width: 25%;">
          <!--          照片-->
          <div>
            <el-image :src="photo.url"></el-image>
          </div>
          <!--          照片名称-->
          <div style="height: 50px;display: flex;justify-content: space-evenly;align-items: center">
            <span>
              {{ photo.title }}
            </span>
          </div>
          <!--        todo  照片功能按钮-->
          <div style="display:flex;justify-content: center">
            <el-button text>
              <el-icon>
                <Star/>
              </el-icon>
            </el-button>
            <el-button text>
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
      </div>
    </el-scrollbar>
  </div>
</template>
<script lang="ts" setup>

import {DeleteFilled, Edit, Plus, Sort, Star} from '@element-plus/icons-vue'
import {useStore} from "vuex";
import {ElMessageBox, UploadInstance} from "element-plus";
import {ref} from "vue";

const store = useStore()
const uploadVisible = ref(false)
const upload_btn = ref(false)

//上传照片 todo
const handleSuccess = (res, file, fileList) => {
  console.log(res, file, fileList)


  // 上传成功后，将上传按钮隐藏
  upload_btn.value = true
}


//上传提交
const submitUpload = () => {

}

const photoName = ref('')
const photoDescription = ref('')


const deletePhotoDialog = (photo) => {
  console.log(photo)
  ElMessageBox.confirm('此操作将永久删除该照片, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    store.commit('deletePhoto', photo)
    ElMessageBox({
      type: 'success',
      message: '删除成功!'
    });
  }).catch(() => {
    ElMessageBox({
      type: 'info',
      message: '已取消删除'
    });
  });
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