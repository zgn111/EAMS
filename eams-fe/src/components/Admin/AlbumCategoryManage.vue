<template>
  <el-main>
    <div>
      <el-button type="primary" @click="addNewCategoryVisible=true">
        <el-icon>
          <Plus/>
        </el-icon>
        新建相册分类
      </el-button>
    </div>
    <el-dialog
        v-model="addNewCategoryVisible"
        title="新建相册分类"
        class="upload"
        @close="addNewCategoryVisible = false"
        >
      <el-form style="justify-content: center;display: flex">
        <el-form-item label="相册类别" label-width="80px">
          <el-input v-model="inputCategory"  placeholder="请输入相册类别" style="width: 200px"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button size="small" type="primary" @click="addNewCategory">确定</el-button>
      </template>
    </el-dialog>
    <el-table :data="albumCategoryList.slice((currentPage-1)*pageSize,currentPage*pageSize)" border>
      <el-table-column prop="index" label="序号" width="60px"></el-table-column>
      <el-table-column prop="albumCategoryName" label="相册类别"></el-table-column>
      <el-table-column prop="albumCategoryCreateDate" label="创建时间"></el-table-column>
      <el-table-column prop="albumNum" label="相册数量"></el-table-column>
      <el-table-column label="操作" width="200px">
        <template #default="scope">
          <el-button type="primary" size="small" @click="toSelectedAlbumCategory(scope.row)">查看所有相册</el-button>
          <el-button type="danger" size="small" @click="deleteSelectedCategory(scope.row)">删除</el-button>
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
        :total="albumCategoryList.length"
    >
    </el-pagination>
  </el-footer>
</template>


<script lang="ts" setup>
import router from "@/router";
import {Plus} from "@element-plus/icons-vue";
import {ElMessageBox} from "element-plus";
import {onMounted, reactive, ref} from "vue";
import api from "@/api/api";
import {useStore} from "vuex";

const store = useStore()

const addNewCategoryVisible = ref(false)
const inputCategory = ref('')
const addNewCategory = async () => {
  const res = await api.addNewAlbumCategory(inputCategory.value)
  if (res.code === 200) {
    await ElMessageBox.alert('添加成功', '提示', {
      confirmButtonText: '确定',
      callback: () => {
        location.reload()
      }
    })
  }
}


const albumCategoryList = reactive([])
onMounted(async () => {
  const res = await api.getAllAlbumCategory()
  for (let i = 0; i < res.data.length; i++) {
    albumCategoryList.push({
      index: res.data[i].categoryId,
      albumCategoryName: res.data[i].categoryName,
      albumCategoryCreateDate: res.data[i].categoryCreateDate,
      albumNum: res.data[i].albumCount
    })
  }
  localStorage.setItem('admin-albumCategoryList', JSON.stringify(albumCategoryList))
})


let currentPage = ref(1)
let pageSize = ref(10)


/**
 * 跳转到相册页面
 * @param row
 */
const toSelectedAlbumCategory = (row) => {
  console.log(row)
  store.commit('setAdminSelectAlbumCategory', row.index)
  router.push('/admin/albumCategory' + '/' + row.albumCategoryName
  )
}

const deleteSelectedCategory = (row) => {
  ElMessageBox.confirm('此操作将永久删除该分类, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    const res = await api.deleteAlbumCategory(row.index)
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