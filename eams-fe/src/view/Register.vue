<template>
  <div>
    <el-container class="register-page">
      <el-header style="display: flex;justify-content: center;align-items: center">
        <h1>
          电子相册管理系统注册界面
        </h1>
      </el-header>
      <el-main>
        <div>
          <el-form class="register-form"
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
            <el-form-item label="确认密码" label-width="80px" prop="checkPassword">
              <el-input v-model="ruleForm.checkPassword" placeholder="请再次输入密码" type="password"></el-input>
            </el-form-item>
            <el-form-item class="submitButton">
              <el-button style="width: 120px;" type="primary" @click="submitForm">注册</el-button>
            </el-form-item>
          </el-form>
        </div>

      </el-main>
      <el-footer>
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

const ruleFormRef = ref<FormInstance>();
import api from "../api/api";
import router from "@/router";

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

const validateCheckPassword = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请再次输入密码'));
  } else if (value !== ruleForm.password) {
    callback(new Error('两次输入密码不一致'));
  } else {
    callback();
  }
}

const ruleForm = reactive({
  username: '',
  password: '',
  checkPassword: ''
});
const rules: FormRules = {
  username: [
    {validator: validateUsername, trigger: 'blur'}
  ],
  password: [
    {validator: validatePassword, trigger: 'blur'}
  ],
  checkPassword: [
    {validator: validateCheckPassword, trigger: 'blur'}
  ]
};

const submitForm = () => {
  ruleFormRef.value.validate(async (valid) => {
    if (valid) {
      // 注册
      const userData = {
        username: ruleForm.username,
        password: ruleForm.password
      }
      try {
        const res = await api.register(userData)
        console.log(res)
        if (res.data === true) {

          alert('注册成功')
          await router.push('/login')

        } else if (res.data === false) {
          ruleForm.username = ''
          ruleForm.password = ''
          ruleForm.checkPassword = ''
          setTimeout(() => {
            alert('账号已存在')
          }, 100)
        }
      } catch (e) {
        console.log(e)
      }
    } else {
      console.log('error submit!');
      return false;
    }
  })
}
</script>


<style scoped lang="less">
.register-page {
  height: 97.5vh;
  background-image: url("../assets/login.jpg");
}

.register-form {
  width: 300px;
  margin: 0 auto;
  padding-top: 100px;
}

.submitButton :deep(.el-form-item__content) {
  justify-content: center;
}
</style>