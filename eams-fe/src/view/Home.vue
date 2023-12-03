<script setup>

import Main from "@/components/Home/Main.vue";
import AsideMenu from "@/components/Home/AsideMenu.vue";
import HeaderMenu from "@/components/Home/HeaderMenu.vue";


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


<style lang="less" scoped>
.el-header {
  display: contents;
  align-items: center;
}

</style>