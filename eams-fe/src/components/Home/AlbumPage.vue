<template>
<div class="album-page">
  <el-scrollbar>
    <div class="albums">
      <div v-for="album in 6" :key="album" :class="'album'" style="width: 25%;">
        <el-empty description="description"  @click="jumpToPhotoPage(album)"/>
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
const albumCategory = store.state.albumCategory


//when click the album, it will jump to the photo page
const jumpToPhotoPage = (album) => {
  router.push({
    path: '/photo'
  })

  // console.log('jump to photo page')
}


</script>
<style scoped lang="less">
.album-page{
  height: 750px;
}
.albums{
  display: flex;
  flex-wrap: wrap;
}
</style>