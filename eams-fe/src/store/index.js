import {createStore} from "vuex";
import mutations from "./mutations";
import actions from "./actions";
import {reactive, ref} from "vue";

const store = createStore({
    state() {
        return {
            selectedAlbumCategory: ref(''),//当前选中的相册分类路径
            adminId: 1,//当前登录的管理员id
            userId: 1,//当前登录的用户id
            currentAlbums: reactive([]),
            selectedAllAlbums: reactive([]),//某一类别下的所有相册
            selectedAlbum: reactive([]),//某一相册下的所有照片
            categoryId:ref(),
            albumId:ref(),
            albumName:ref(),//当前相册名称
            albumCategory:ref(),//当前相册分类
        }
    },
    mutations,
    actions,


})
export default store;