<template>
  <div class="header-search">
    <div>
      <el-input v-model="search" placeholder="搜索" style="width: 400px">
        <template #append>
          <el-button :icon="Search"/>
        </template>
      </el-input>
    </div>

    <div>
      <el-button type="primary" @click="uploadVisible=true" style="background-color: cornflowerblue">
        <el-icon>
          <UploadFilled/>
        </el-icon>
      </el-button>
    </div>

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
  <el-dialog
      v-model="uploadVisible"
      title="上传"
      class="upload"
      @close="uploadVisible = false"
  >

    <el-select v-model="value" clearable placeholder="请选择相册类别">
      <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
      />
    </el-select>
    <div>
      <el-upload
          v-model="fileList"
          class="upload-picture"
          method="post"
          action="https://jsonplaceholder.typicode.com/posts/"
          accept="image/*"
          :on-preview="handlePreview"
          :on-success="handleUploadSuccess"
          :on-error="handleUploadError"
          on-exceed="handleExceed"
      >
        <el-button type="primary">
          <span>
            点击上传
          </span>
        </el-button>
      </el-upload>
    </div>
  </el-dialog>
  </div>
</template>

<script lang="ts" setup>
import {ref} from 'vue'
import {Search, UploadFilled, Avatar, UserFilled} from '@element-plus/icons-vue'

const accountVisible = ref(false)
const settingsVisible = ref(false)
const uploadVisible = ref(false)
const mode = ref(false)
const search = ref('')

const value = ref('')
const options = [
  {
    value: '1',
    label: '人物'
  },
  {
    value: '2',
    label: '风景'
  }
]


</script>


<style lang="less" scoped>
.header-search {
  display: flex;
  justify-content: space-between;
  align-items: center;

}


</style>