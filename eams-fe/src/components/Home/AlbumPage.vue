<template>
  <div :class="store.state.selectedAlbumCategory" style="height: 750px">
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
        title="新建相册"
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
        <div v-for="album in store.state.albums.filter(album=>album.category===store.state.selectedAlbumCategory)"
             :key="album" :class="album.category" style="width: 25%;">
          <!--          相册封面-->
          <div>
            <el-image :src="album.cover" @click="jumpToPhotoPage(album)" style="width: inherit;"
                      :fit="'cover'"></el-image>
          </div>
          <!--          相册名称-->
          <div style="height: 50px;display: flex;justify-content: space-evenly;align-items: center;">
            <span>{{ album.title }}</span>
          </div>
          <!--       todo   相册功能按钮-->
          <div style="display: flex;justify-content: center;">
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
import {ref} from "vue";

const store = useStore()

const albumName = ref('')
const albumDescription = ref('')
const uploadVisible = ref(false)

//添加新相册
const addNewAlbum = () => {
  let newAlbum = {
    aid: store.state.albums.length + 1,
    title: albumName.value,
    description: albumDescription.value,
    category: store.state.selectedAlbumCategory,
    cover: '',
    photos: []
  }
  if(albumName.value === ''||albumDescription.value=== ''){
    ElMessageBox({
      type: 'warning',
      message: '相册名称和相册描述不能为空!'
    });
    return
  }
  store.commit('addAlbum', newAlbum)
  uploadVisible.value = false
  albumName.value = ''
  albumDescription.value = ''

}


//when click the album, it will jump to the selected album page todo
const jumpToPhotoPage = (album) => {
  router.push({
    path: store.state.selectedAlbumCategory + '/' + `${album.title}`
  })
  store.commit('setSelectedAlbum', album)

  console.log(store.state.selectedAlbum)


}


const deleteAlbumDialog = (album) => {
  ElMessageBox.confirm('此操作将永久删除该相册, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    store.commit('deleteAlbum', album)
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

.albums {
  display: flex;
  flex-wrap: wrap;
}
</style>