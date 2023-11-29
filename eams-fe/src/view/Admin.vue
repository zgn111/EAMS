<script setup>

import AsideMenu from "@/components/Admin/AsideMenu.vue";
import HeaderMenu from "@/components/Admin/HeaderMenu.vue";
import Main from "@/components/Admin/Main.vue";


</script>

<template>
  <div>
    <el-container style="height: 97.5vh;">
      <el-aside width="250px">
        <AsideMenu/>
      </el-aside>
      <el-container>
        <el-header>
          <HeaderMenu/>
        </el-header>
        <el-main>
          <Main/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped lang="less">
.el-header {
  display: contents;
  align-items: center;
}
</style>