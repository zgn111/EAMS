import {createRouter, createWebHistory} from 'vue-router';
import Home from '@/view/Home.vue';
import Login from '@/view/Login.vue';
import Register from '@/view/Register.vue';
import PhotoPage from "@/components/Home/PhotoPage.vue";
import HomePage from "@/components/Home/HomePage.vue";
import AlbumPage from "@/components/Home/AlbumPage.vue";
import Admin from "@/view/Admin.vue";


//定义路由
const routes = [
    {
        path: '/',
        component: Home,
        name: 'home',
        children: [{
            path: '/',
            component: HomePage
        }, {
            path: '/album',
            children: [{
                path: '/album/:id',
                component: AlbumPage
            }
            ]
        }, {
            path: '/photo',
            component: PhotoPage
        }
        ]
    },
    {
        path: '/login',
        component: Login,
        name: 'login'
    },
    {
        path: '/register',
        component: Register,
        name: 'register'
    },
    {
        path: '/admin',
        component: Admin,
        name: 'admin'
    }


]

//创建路由
const router = createRouter({
    //采用history模式,摆脱了url中的#号，使得url更加美观
    history: createWebHistory('/'),
    routes: routes,

})

export default router;