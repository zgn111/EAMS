<template>
  <div class="header-search">
    <div>
      <el-input v-model="search" placeholder="搜索" style="width: 400px">
        <template #append>
          <el-button :icon="Search"/>
        </template>
      </el-input>
    </div>
    <div class="user">
      <el-dropdown trigger="click">
       <el-avatar
         src="/src/assets/njnu.jpg">
       </el-avatar>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="accountVisible=true">账户</el-dropdown-item>
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
  </div>
</template>

<script lang="ts" setup>
import {ref} from 'vue'
import {Search} from '@element-plus/icons-vue'

const accountVisible = ref(false)

const search = ref('')




</script>


<style lang="less" scoped>
.header-search {
  display: flex;
  justify-content: space-between;
  align-items: center;

}


</style>