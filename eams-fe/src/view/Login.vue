<template>
  <div>
    <el-container class="login-page">
      <el-header style="display: flex;justify-content: center;align-items: center">
        <h1>
          电子相册管理系统登录界面
        </h1>
      </el-header>
      <el-main>
        <div>
          <el-form class="login-form"
                   ref="ruleFormRef"
                   :model="ruleForm"
                   status-icon
                   :rules="rules"
          >
            <el-form-item label="账号" label-width="80px" prop="username">
              <el-input v-model="ruleForm.username" placeholder="请输入账号"></el-input>
            </el-form-item>
            <el-form-item label="密码" label-width="80px" prop="password">
              <el-input v-model="ruleForm.password" placeholder="请输入密码" type="password"></el-input>
            </el-form-item>
            <el-form-item class="toRegister">
              <el-link>忘记密码</el-link>
              <el-link href="/register">注册账号</el-link>
            </el-form-item>
            <el-form-item class="submitButton">
              <el-button style="width: 120px;" type="primary" @click="submitForm">登录</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-main>
      <el-footer>
        <!--       版权-->
        <div style="display: flex;justify-content: center;align-items: center">
          <span>© 2023-</span>
          <el-link href="">电子相册管理系统</el-link>

        </div>
      </el-footer>
    </el-container>
  </div>
</template>
<script lang="ts" setup>
import {reactive, ref} from "vue";
import type {FormInstance, FormRules} from "element-plus";
import router from "@/router";

const ruleFormRef = ref<FormInstance>();


const validateUsername = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请输入账号'));
  } else if (!/^[a-zA-Z0-9]{4,16}$/.test(value)) {
    callback(new Error('账号为4到16位，由字母、数字的组合'));
  } else {
    callback();
  }
}
const validatePassword = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请输入密码'));
  } else if (!/^[a-zA-Z0-9]{6,16}$/.test(value)) {
    callback(new Error('密码为6到16位，由字母、数字的组合'));
  } else {
    callback();
  }
}

const ruleForm = reactive({
  username: '',
  password: ''
});

const rules = reactive<FormRules<typeof ruleForm>>({
  username: [{validator: validateUsername, trigger: 'blur'}],
  password: [{validator: validatePassword, trigger: 'blur'}]
});


// 提交表单 todo
const submitForm = () => {
  ruleFormRef.value.validate((valid) => {
    if (valid) {
      console.log('submit!');
      // 跳转到首页
      router.replace('/')
    } else {
      console.log('error submit!');
      return false;
    }
  })
}


</script>
<style scoped lang="less">
.login-page {
  height: 97.5vh;

}

.login-form {
  width: 300px;
  margin: 0 auto;
  padding-top: 100px;
}

.el-form-item {
  margin-bottom: 30px;
}

.el-form-item :deep(.el-form-item__label) {
  justify-content: center;
}


.submitButton :deep(.el-form-item__content) {
  justify-content: center;
}

.toRegister :deep(.el-form-item__content) {
  justify-content: space-between;
}
</style>