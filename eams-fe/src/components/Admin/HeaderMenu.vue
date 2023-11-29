<script  setup>

import {UploadFilled} from "@element-plus/icons-vue";
</script>

<template>
  <div class="header-search">
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
  justify-content: flex-end;
  align-items: center;

}

</style>