<script lang="ts" setup>
import router from "@/router";
import {onMounted, ref} from "vue";

const isActive = ref(false)
const goBack = () => {
  //如果地址栏中有/admin/albumCategory/xxx/xxx，则返回/admin/albumCategory/xxx，其余情况点击无效，不会跳转
  const currentPath = window.location.pathname;
  console.log(currentPath)
  const regex = /\/admin\/albumCategory\/([^/]+)/;
  const match = currentPath.match(regex);
  if (match) {
    const albumCategoryName = decodeURIComponent(match[1]);
    router.push('/admin/albumCategory' + '/' + albumCategoryName)
    isActive.value = true;
  }

}

</script>
<!--todo bug-->
<template>
  <div class="header-search">
    <el-breadcrumb>
      <el-breadcrumb-item :to="{path: '/admin'}">首页</el-breadcrumb-item>
      <el-breadcrumb-item :to="{path: '/admin/albumCategory'}">相册分类</el-breadcrumb-item>
      <el-breadcrumb-item :to="{path: ''}" @click="goBack">相册</el-breadcrumb-item>
      <el-breadcrumb-item>相册名</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="user">
      <el-dropdown trigger="click">
        <el-avatar
            src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png">
        </el-avatar>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="accountVisible=true">账户</el-dropdown-item>
            <el-dropdown-item @click="settingsVisible=true">设置</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>

    <el-dialog
        v-model="accountVisible"
        title="账户"
        class="account"
        @close="accountVisible = false">
      <!--todo 账户功能-->
      <el-button>
        <el-link type="primary" href="/login">退出登录</el-link>
      </el-button>

    </el-dialog>
    <el-dialog
        v-model="settingsVisible"
        title="设置"
        class="settings"
        @close="settingsVisible = false"
    >
      <div>
        <span> 模式</span>
        <el-switch v-model="mode"/>
      </div>
    </el-dialog>
  </div>
</template>

<style scoped lang="less">
.header-search {
  display: flex;
  justify-content: space-between;
  align-items: center;

}

</style>