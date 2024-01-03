<template>
  <div style="height: 750px">
    <div style="display: flex;justify-content: end;align-items: center">
      <el-button @click="uploadVisible=true">
        <el-icon>
          <Plus/>
        </el-icon>
      </el-button>
    </div>
    <el-dialog
        v-model="uploadVisible"
        title="新建相册"
        class="upload"
        @close="uploadVisible = false"
    >
      <el-form>
        <el-form-item label="相册类别" label-width="80px">
          <el-text>
            {{ store.state.selectedAlbumCategory.split('/')[2] }}
          </el-text>
        </el-form-item>
        <el-form-item label="相册名称" label-width="80px">
          <el-input v-model="albumName" placeholder="请输入相册名称"></el-input>
        </el-form-item>
        <el-form-item label="相册描述" label-width="80px">
          <el-input v-model="albumDescription" placeholder="请输入相册描述"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button size="small" type="primary" @click="addNewAlbum">确 定</el-button>
      </template>
    </el-dialog>
    <el-scrollbar>
      <div class="albums">
        <div v-for="album in store.state.selectedAllAlbums"
             :key="album" :class="album.albumName" style="width: 25%;">
          <!--    todo      相册封面-->
          <div>
            <el-image :src="album.coverUrl?album.coverUrl:'http://localhost:5173/src/assets/default-cover.jpeg'"
                      @click="jumpToPhotoPage(album)" style="width: 100%;height: 100px"
                      :fit="'cover'"></el-image>
          </div>
          <div style="height: 50px;display: flex;justify-content: space-evenly;align-items: center;">
            <span>{{ album.albumName }}</span>
          </div>
          <!--       todo   相册功能按钮-->
          <div style="display: flex;justify-content: center;">
            <el-button text @click="editAlbumName(album)">
              <el-icon>
                <Edit/>
              </el-icon>
            </el-button>
            <el-button text @click="deleteAlbumDialog(album)">
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

import {DeleteFilled, Edit, Plus, Sort, Star} from "@element-plus/icons-vue";
import router from "@/router";
import {useStore} from "vuex";
import {ElMessageBox} from "element-plus";
import {onMounted, reactive, ref, watch} from "vue";
import api from "@/api/api";

const store = useStore()
const albumName = ref('')
const albumDescription = ref('')
const uploadVisible = ref(false)

let albums = reactive([])

watch(() => store.state.selectedAlbumCategory, async (newVal, oldVal) => {
  if (newVal !== oldVal) {
    albums = []
    const albumCategoryList = JSON.parse(localStorage.getItem('albumCategoryList'))
    const albumCategory = albumCategoryList.find(item => item["categoryPath"] === newVal);
    var categoryId = albumCategory.categoryId;
    const res = await api.getAlbumsByCategoryId(categoryId)
    for (let i = 0; i < res.data.length; i++) {
      albums.push({
        albumId: res.data[i].albumId,
        albumName: res.data[i].albumName,
        albumDescription: res.data[i].albumDescription,
        coverId: res.data[i].coverId,
        coverUrl: res.data[i].albumCoverUrl,
      })
    }
    store.commit('setSelectedAllAlbums', albums)
  }
})


onMounted(async () => {
  //在localStorage中存储的相册类别列表中查找到对应的相册类别
  const albumCategoryList = JSON.parse(localStorage.getItem('albumCategoryList'))
  // 获取当前 URL 中的路径
  const currentPath = window.location.pathname;
  // 定义匹配路径的正则表达式
  const regex = /\/album\/([^/]+)/;
  // 使用正则表达式进行匹配
  const match = currentPath.match(regex);
  console.log(match)
  if (match) {
    var albumCategoryName = decodeURIComponent(match[1]);
    console.log(albumCategoryName)
    const albumCategory = albumCategoryList.find(item => item["categoryName"] === albumCategoryName);
    var categoryId = albumCategory.categoryId;
    const res = await api.getAlbumsByCategoryId(categoryId)
    for (let i = 0; i < res.data.length; i++) {
      albums.push({
        albumId: res.data[i].albumId,
        albumName: res.data[i].albumName,
        albumDescription: res.data[i].albumDescription,
        coverId: res.data[i].coverId,
        coverUrl: res.data[i].albumCoverUrl !== null ? res.data[i].albumCoverUrl : 'http://localhost:5173/src/assets/default-cover.jpeg',
      })
    }
    console.log(albums)
    localStorage.setItem('albumList' + categoryId, JSON.stringify(res.data))
    store.commit('setSelectedAlbumCategory', albumCategory.categoryPath)
    store.commit('setSelectedAllAlbums', albums)

  }


})

const addNewAlbum = async () => {
  uploadVisible.value = false

  //在localStorage中存储的相册类别列表中查找到对应的相册类别
  const albumCategoryList = JSON.parse(localStorage.getItem('albumCategoryList'))

  // 获取当前 URL 中的路径
  const currentPath = window.location.pathname;
  // 定义匹配路径的正则表达式
  const regex = /\/album\/([^/]+)/;
  // 使用正则表达式进行匹配
  const match = currentPath.match(regex);
  if (match) {
    var albumCategoryName = decodeURIComponent(match[1]);
    const albumCategory = albumCategoryList.find(item => item["categoryName"] === albumCategoryName);
    var categoryId = albumCategory.categoryId;
  }
  const album = {
    albumName: albumName.value,
    albumDescription: albumDescription.value,
    categoryId: categoryId,
    adminId: store.state.adminId,
    userId: 1
  }
  console.log(album)
  const res = await api.addNewAlbum(album)
  if (res.code === 200) {
    await ElMessageBox({
      type: 'success',
      message: '添加成功!'
    });
    location.reload()
  } else {
    await ElMessageBox({
      type: 'error',
      message: '添加失败!'
    });
  }

}


//when click the album, it will jump to the selected album page todo
const jumpToPhotoPage = (album) => {
  console.log(album)
  router.push({
    path: store.state.selectedAlbumCategory + '/' + `${album.albumName}`
  })
  store.commit('setSelectedAlbum', album)
  store.commit('setAlbumId', album.albumId)
  store.commit('setAlbumCategory', store.state.selectedAlbumCategory.split('/')[2])
  store.commit('setAlbumName', album.albumName)

}

const editAlbumName = (album) => {
  console.log(album)
  ElMessageBox.prompt('请输入新的相册名称', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    inputValue: album.albumName,
    inputPattern: /\S/,
    inputErrorMessage: '相册名称不能为空'
  }).then(async ({value}) => {
    console.log(value)
    console.log(album.albumId)
    const res = await api.updateAlbumName(album.albumId, value)
    console.log(res)
    if (res.code === 200) {
      await ElMessageBox({
        type: 'success',
        message: '修改成功!'
      });
      location.reload()
    } else {
      await ElMessageBox({
        type: 'error',
        message: '修改失败!'
      });
    }
  })
}


const deleteAlbumDialog = (album) => {
  ElMessageBox.confirm('此操作将永久删除该相册, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {

    const res = await api.deleteAlbum(album.albumId)
    console.log(res)
    if (res.code === 200) {
      await ElMessageBox({
        type: 'success',
        message: '删除成功!'
      });
      location.reload()
    } else {
      await ElMessageBox({
        type: 'error',
        message: '删除失败!'
      });
    }

  })
}


</script>
<style scoped lang="less">

.albums {
  display: flex;
  flex-wrap: wrap;
}
</style>