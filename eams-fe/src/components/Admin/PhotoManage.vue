<template>
  <el-main>
    <el-table :data="photoList.slice((currentPage-1)*pageSize,currentPage*pageSize)" border>
      <el-table-column type="index" label="序号" width="60px"></el-table-column>
      <el-table-column prop="photoName" label="照片名"></el-table-column>
      <el-table-column prop="photoUrl" label="照片预览">
        <template #default="scope">
          <img :src="scope.row.photoUrl" width="100" height="100"/>
        </template>
      </el-table-column>
      <el-table-column prop="photoDesc" label="照片描述">
      </el-table-column>
      <el-table-column prop="userId" label="所属用户"></el-table-column>
      <el-table-column prop="photoUrl" label="照片地址">
      </el-table-column>
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
        :total="photoList.length"
    >
    </el-pagination>
  </el-footer>
</template>


<script lang="ts" setup>
import router from "@/router";
import {ElMessage, ElMessageBox} from "element-plus";
import {onMounted, reactive, ref} from "vue";
import api from "@/api/api";
import {useStore} from "vuex";

const store = useStore()

const currentPage = ref(1)
const pageSize = ref(10)

let photoList = reactive([])
onMounted(async () => {
  //在localStorage中存储的相册列表中查找到对应的相册
  const albumList = JSON.parse(localStorage.getItem('admin-albumList'))
  // 获取当前 URL 中的路径
  const currentPath = window.location.pathname;

  // 定义匹配路径的正则表达式
  const regex = /\/admin\/albumCategory\/([^/]+)\/([^/]+)/;
  // 使用正则表达式进行匹配
  const match = currentPath.match(regex);
  console.log(match)
  if (match) {
    const albumName = decodeURIComponent(match[2]);
    const album = albumList.find(item => item["albumName"] === albumName);
    var albumId = album.index;
    const res = await api.getPhotoByAlbumId(albumId)
    console.log(res)
    for (let i = 0; i < res.data.length; i++) {
      photoList.push({
        index: res.data[i].photoId,
        photoName: res.data[i].photoName,
        photoDesc: res.data[i].photoDescription,
        userId: res.data[i].userId,
        photoUrl: res.data[i].photoUrl
      })
    }
    localStorage.setItem('admin-photoList', JSON.stringify(photoList))
  }
})


const handleDelete = (row) => {
  ElMessageBox.confirm('此操作将永久删除该照片, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    const res = await api.deletePhoto(row.index)
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