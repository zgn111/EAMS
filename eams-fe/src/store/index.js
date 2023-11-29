import {createStore} from "vuex";
import mutations from "./mutations";
import actions from "./actions";
import {LocationFilled, UserFilled} from "@element-plus/icons-vue";

const store = createStore({
    state() {
        return {
            albumCategory: [
                {
                    index: '/album/people',
                    title: '人物',
                    icon: "UserFilled"
                },
                {
                    index: '/album/scenery',
                    title: '风景',
                    icon: "LocationFilled"
                }

            ],
            albums: [
                {
                    id: 1,
                    description: "相册描述",
                    title: "相册标题",
                    category: "people",
                    cover: "",

                }
            ],
            photos: [
                {
                    id: 1,
                    albumId: 1,
                    url: "",
                    description: "图片描述",
                    title: "图片标题",
                    category: "people",
                }
            ],
        }
    },
    mutations,
    actions,


})
export default store;