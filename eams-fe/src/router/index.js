import {createRouter, createWebHistory} from 'vue-router';

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
            path: 'album/:category',
            component: () => import('@/components/Home/AlbumPage.vue'),
        },
            {
                path: 'album/:category/:albumId',
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
                path: 'albumCategory',
                component: () => import('@/components/Admin/AlbumCategoryManage.vue'),

            },
            {
                path: 'albumCategory/:categoryId',
                component: () => import('@/components/Admin/AlbumManage.vue')
            },
            {
                path: 'albumCategory/:categoryId/:albumId',
                component: () => import('@/components/Admin/PhotoManage.vue')
            },
            {
                path: 'user',
                component: () => import('@/components/Admin/UserManage.vue')
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