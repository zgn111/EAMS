import {createRouter, createWebHistory} from 'vue-router';
import Home from "@/view/Home.vue";
import HomePage from "@/components/Home/HomePage.vue";
import PhotoPage from "@/components/Home/PhotoPage.vue";
import AlbumPage from "@/components/Home/AlbumPage.vue";


//定义路由
const routes = [
    {
        path: '/',
        component: () => import('@/view/Home.vue'),
        name: 'home',
        children: [{
            path: '/',
            component: () => import('@/components/Home/HomePage.vue'),
        }, {
            path: '/album/:category',
            component: () => import('@/components/Home/AlbumPage.vue'),
        },
            {
                path: '/album/:category/:albumId',
                component: () => import('@/components/Home/PhotoPage.vue'),
            }
        ]
    },
    {
        path: '/login',
        component: () => import('@/view/Login.vue'),
        name: 'login'
    },
    {
        path: '/register',
        component: () => import('@/view/Register.vue'),
        name: 'register'
    },
    {
        path: '/admin',
        component: () => import('@/view/Admin.vue'),
        name: 'admin',
        children: [
            {
                path: '/admin/album',
                component: () => import('@/components/Home/AlbumPage.vue')
            }
        ]
    }


]

//创建路由
const router = createRouter({
    //采用history模式,摆脱了url中的#号，使得url更加美观
    history: createWebHistory('/'),
    routes: routes,

})

export default router;