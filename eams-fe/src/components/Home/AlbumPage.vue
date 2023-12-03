<template>
  <div class="album-page">
    <el-scrollbar>
      <div class="albums">
        <div v-for="album in 6" :key="album" :class="'album'" style="width: 25%;">
          <el-empty description="description" @click="jumpToPhotoPage(album)"
                    image="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"/>
          <div style="height: 50px;display: flex;justify-content: space-evenly">
            <span>相册名称</span>
            <el-button>
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

<script setup>

import {DeleteFilled} from "@element-plus/icons-vue";
import router from "@/router";
import {useStore} from "vuex";

const store = useStore()


//when click the album, it will jump to the selected album page todo
const jumpToPhotoPage = (album) => {
  router.push({
    path: store.state.selectedAlbumCategory + '/' + `${album}`
  })

}


</script>
<style scoped lang="less">
.album-page {
  height: 750px;
}

.albums {
  display: flex;
  flex-wrap: wrap;
}
</style>