<template>
  <div>
    <el-container class="login-page">
      <el-header>
        Header
      </el-header>
      <el-main>
        <div>
          <el-form class="login-form"
          status-icon
          :r
          >
            <el-form-item label="用户名">
              <el-input v-model="username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary">登录</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-main>
      <el-footer>
        Footer
      </el-footer>
    </el-container>
  </div>
</template>
<script  setup>
import {ref} from "vue";

const username = ref('');
const password = ref('');
</script>
<style scoped>
.login-page {
  height: 100vh;

}

.login-form {
  width: 300px;
  margin: 0 auto;
  padding-top: 100px;
}
</style>