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
      <el-menu-item v-for="item in albumCategory" :key="item.index" :index="item.index" @select="item.index">
        <el-icon>
          <component :is="getIconComponent(item.icon)"/>
        </el-icon>
        <span>{{ item.title }}</span>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>

</template>

<script lang="ts" setup>
import {ref} from 'vue'
import {HomeFilled, PictureFilled, UserFilled, LocationFilled} from '@element-plus/icons-vue'
import {useStore} from "vuex";


const activeIndex = ref('/')
const store = useStore()

const albumCategory = store.state.albumCategory


function getIconComponent(icon: string) {
  switch (icon) {
    case 'UserFilled':
      return UserFilled
    case 'LocationFilled':
      return LocationFilled
    default:
      return HomeFilled
  }
}

const handleSelect = (index: string) => {
  activeIndex.value = index
  store.commit('setSelectedAlbumCategory', index)
  console.log(store.state.selectedAlbumCategory)
  console.log(index)
}
</script>

<style lang="less" scoped>


</style>