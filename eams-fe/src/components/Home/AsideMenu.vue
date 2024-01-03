<template>
  <el-menu
      :default-active="activeIndex"
      class="user-aside-menu"
      @select="handleSelect"
      :router="true"
  >
    <el-menu-item index="/">
      <el-icon>
        <HomeFilled/>
      </el-icon>
      <span>首页</span>
    </el-menu-item>
    <el-sub-menu index="/album">
      <template #title>
        <div>
          <el-icon>
            <PictureFilled/>
          </el-icon>
          <span>相册类别管理</span>
        </div>
      </template>
      <el-menu-item v-for="item in albumCategory" :key="item.index" :index="item.path">
        <span>{{ item.albumCategoryName }}</span>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script lang="ts" setup>
import {onMounted, reactive, ref} from 'vue'
import {HomeFilled, PictureFilled} from '@element-plus/icons-vue'
import {useStore} from "vuex";
import api from "@/api/api";

const store = useStore()
const activeIndex = sessionStorage.getItem('curIndex') || '/'

const albumCategory = reactive([])
onMounted(async () => {
  try {
    const res = await api.getAllAlbumCategory()
    console.log(res)
    for (let i = 0; i < res.data.length; i++) {
      albumCategory.push({
        index: res.data[i].categoryId,
        albumCategoryName: res.data[i].categoryName,
        path: res.data[i].categoryPath
      })
    }
    localStorage.setItem('selectedAlbumCategory', JSON.stringify(albumCategory[0].albumCategoryName))
    localStorage.setItem('albumCategoryList', JSON.stringify(res.data))
  } catch (e) {
    console.log(e)
  }
})

// 选中的相册类别
const handleSelect = async (index: string) => {
  sessionStorage.setItem('curIndex', index)
  if (index === '/') {
    return
  } else {
    await store.commit('setSelectedAlbumCategory', index)
    const albumCategoryList = JSON.parse(localStorage.getItem('albumCategoryList'))
    const albumCategory = albumCategoryList.find(item => item["categoryPath"] === index);
    var categoryId = albumCategory.categoryId;
    store.commit('setCategoryId', categoryId)
    store.commit('setAlbumCategory', albumCategory.categoryName)
    console.log(store.state.selectedAlbumCategory)

  }
}

</script>

<style lang="less" scoped>

.user-aside-menu{
  height: 100%;
}


</style>