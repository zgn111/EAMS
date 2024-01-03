<template>
  <el-main>
    <el-table :data="albumList.slice((currentPage-1)*pageSize,currentPage*pageSize)" border>
      <el-table-column prop="index" label="序号" width="60px"></el-table-column>
      <el-table-column prop="albumName" label="相册名"></el-table-column>
      <el-table-column prop="albumDesc" label="相册描述"></el-table-column>
      <el-table-column prop="albumCover" label="相册封面"></el-table-column>
      <el-table-column prop="userId" label="所属用户"></el-table-column>
      <el-table-column label="操作" width="200px">
        <template #default="scope">
          <el-button type="primary" size="small" @click="toSelectedAlbum(scope.row)">查看</el-button>
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
        :total="albumList.length"
    >
    </el-pagination>
  </el-footer>
</template>


<script lang="ts" setup>
import router from "@/router";
import {ElMessageBox} from "element-plus";
import {onMounted, reactive, ref} from "vue";
import api from "@/api/api";
import {useStore} from "vuex";

const store = useStore()
let albumList = reactive([])
onMounted(async () => {
  //在localStorage中存储的相册类别列表中查找到对应的相册类别
  const albumCategoryList = JSON.parse(localStorage.getItem('admin-albumCategoryList'))
  // 获取当前 URL 中的路径
  const currentPath = window.location.pathname;
  // 定义匹配路径的正则表达式
  const regex = /\/admin\/albumCategory\/([^/]+)/;
  // 使用正则表达式进行匹配
  const match = currentPath.match(regex);
  if (match) {
    const albumCategoryName = decodeURIComponent(match[1]);
    const albumCategory = albumCategoryList.find(item => item["albumCategoryName"] === albumCategoryName);
    var categoryId = albumCategory.index;
    const res = await api.getAlbumsByCategoryId(categoryId)
    for (let i = 0; i < res.data.length; i++) {
      albumList.push({
        index: res.data[i].albumId,
        albumName: res.data[i].albumName,
        albumDesc: res.data[i].albumDescription,
        albumCover: res.data[i].coverId,
        userId: res.data[i].userId
      })
    }
    localStorage.setItem('admin-albumList', JSON.stringify(albumList))

  }
})
let currentPage = ref(1)
let pageSize = ref(10)


/**
 * 跳转到选中的相册
 * @param row
 */
const toSelectedAlbum = (row) => {
  console.log(row)
  //获取主机地址之后的目录
  let pathName = window.document.location.pathname

  store.commit('setAdminSelectAlbum', row.index)
  router.push(pathName + '/' + row.albumName)
}

/**
 * 删除相册
 * @param row
 */
const handleDelete = (row) => {
  ElMessageBox.confirm('此操作将永久删除该相册, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    const res = await api.deleteAlbum(row.index)
    if (res.code === 200) {
      await ElMessageBox.alert('删除成功', '提示', {
        confirmButtonText: '确定',
        callback: () => {
          location.reload()
        }
      })
    }

  })
}

</script>
<style scoped lang="less">

</style>