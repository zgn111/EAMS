<template>
  <el-main>
    <el-table :data="userList.slice((currentPage-1)*pageSize,currentPage*pageSize)" border>
      <el-table-column prop="index" label="序号" width="60px"></el-table-column>
      <el-table-column prop="userName" label="用户名"></el-table-column>
      <el-table-column prop="registerTime" label="注册时间"></el-table-column>
      <el-table-column prop="isDisabled" label="是否禁用"></el-table-column>
      <el-table-column label="操作" width="200px">
        <template #default="scope">
          <el-button type="primary" size="small" @click="handleDisable(scope.row)">
            {{ disableButton(scope.row) }}
          </el-button>
          <el-button type="danger" size="small" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

  </el-main>
  <el-footer style="display:flex;justify-content: center;align-items: center">
    <el-pagination
        v-model:current-page="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[5, 10, 20, 50]"
        layout="prev, pager, next,jumper, ->,total"
        :total="userList.length"
    >
    </el-pagination>
  </el-footer>
</template>


<script lang="ts" setup>
import {ElMessageBox} from "element-plus";
import {useStore} from "vuex";
import api from "@/api/api";
import {onMounted, reactive, ref, watch} from "vue";

const store = useStore()

let currentPage = ref(1)
let pageSize = ref(10)


let userList = reactive([])
onMounted(async () => {
  const res = await api.getAllUsers(store.state.adminId)
  for (let i = 0; i < res.data.length; i++) {
    userList.push({
      index: res.data[i].id,
      userName: res.data[i].username,
      registerTime: res.data[i].registerDate,
      isDisabled: (res.data[i].disabled === false) ? '否' : '是'
    })

  }
})

const disableButton = (row) => {
  if (row.isDisabled === '否') {
    return '禁用'
  } else {
    return '解禁'
  }
}

const handleDisable = async (row) => {
  if (row.isDisabled === '否') {
    const res = await api.setUserStatus(row.index, true)
    if (res.code === 200) {
      await ElMessageBox.alert('禁用成功', '提示', {
        confirmButtonText: '确定',
        callback: () => {
          location.reload()
        }
      })

    }
  } else {
    const res = await api.setUserStatus(row.index, false)
    if (res.code === 200) {
      await ElMessageBox.alert('解禁成功', '提示', {
        confirmButtonText: '确定',
        callback: () => {
          location.reload()
        }
      })

    }
  }
}

const handleDelete = (row) => {
  ElMessageBox.confirm('此操作将永久删除该用户, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    const res = await api.deleteUser(row.index)
    if (res.code === 200) {
      await ElMessageBox.alert('删除成功', '提示', {
        confirmButtonText: '确定',
        callback: () => {
          location.reload()
        }
      })
    }
  });
}


</script>
<style scoped lang="less">

</style>