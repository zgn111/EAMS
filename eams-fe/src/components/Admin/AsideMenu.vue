<script lang="ts" setup>

import {HomeFilled, PictureFilled, UserFilled} from "@element-plus/icons-vue";
</script>

<template>
  <el-menu
      :default-active="activeIndex"
      class="user-aside-menu"
      @select="handleSelect"
      :router="true"
  >
    <el-menu-item index="/admin">
      <el-icon>
        <HomeFilled/>
      </el-icon>
      <span>首页</span>
    </el-menu-item>
   <el-menu-item index="/admin/albumCategory">
      <el-icon>
        <PictureFilled/>
      </el-icon>
      <span>相册管理</span>
   </el-menu-item>
    <el-menu-item index="/admin/user">
      <el-icon>
        <UserFilled/>
      </el-icon>
      <span>用户管理</span>
    </el-menu-item>
  </el-menu>
</template>

<style scoped lang="less">

</style>