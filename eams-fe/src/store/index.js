import {createStore} from "vuex";
import mutations from "./mutations";
import actions from "./actions";

const store = createStore({
    state() {
        return {
            selectedAlbumCategory: null,//当前选中的相册分类
            selectedAlbum:
                {
                    aid: -1,
                    category: "",
                    title: "",
                    description: "",
                    photos: [],
                    cover: ""
                }
            ,//当前选中的相册
            albumCategory: [
                {
                    path: '/album/people',
                    title: '人物',
                    icon: "UserFilled"
                },
                {
                    path: '/album/scenery',
                    title: '风景',
                    icon: "LocationFilled"
                }

            ],
            albums: [
                {
                    aid: 1,
                    category: "/album/people",
                    title: "人物相册1",
                    description: "人物相册1描述",
                    photos: [
                        {
                            pid: 1,
                            url: 'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
                            description: "人物相册1描述1",
                            title: "人物相册1标题1"
                        },
                        {
                            pid: 2,
                            url: 'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
                            description: "人物相册1描述2",
                            title: "人物相册1标题2"

                        }
                    ],
                    cover: "https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg",
                },
                {

                    aid: 2,
                    category: "/album/people",
                    title: "人物相册2",
                    description: "人物相册2描述",
                    photos: [
                        {
                            pid: 1,
                            url: "https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg",
                            description: "人物相册2描述1"

                        }
                    ],
                    cover: "https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg",
                },
                {
                    aid: 3,
                    category: "/album/people",
                    title: "人物相册3",
                    description: "人物相册3描述",
                    photos: [
                        {}
                    ],
                    cover: "",
                },
                {
                    aid: 4,
                    category: "/album/people",
                    title: "人物相册4",
                    description: "人物相册4描述",
                    photos: [
                        {}
                    ],
                    cover: "",
                },
                {
                    aid: 5,
                    category: "/album/people",
                    title: "人物相册5",
                    description: "人物相册5描述",
                    photos: [
                        {}
                    ],
                    cover: "",
                },
                {
                    aid: 6,
                    category: "/album/people",
                    title: "人物相册6",
                    description: "人物相册6描述",
                    photos: [
                        {}
                    ],
                    cover: "",
                },
                {
                    aid: 7,
                    category: "/album/scenery",
                    title: "风景相册1",
                    description: "风景相册1描述",
                    photos: [
                        {}
                    ],
                    cover: "https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg",
                },
                {
                    aid: 8,
                    category: "/album/scenery",
                    title: "风景相册2",
                    description: "风景相册2描述",
                    photos: [
                        {}
                    ],
                    cover: "",
                },
            ],
        }
    },
    mutations,
    actions,


})
export default store;