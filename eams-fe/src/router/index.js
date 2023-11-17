import {createRouter,createWebHistory} from  'vue-router';
import Home from '@/view/Home.vue';
import Login from '@/view/Login.vue';
import Register from '@/view/Register.vue';


//定义路由
const routes=[
    {
        path:'/',
        component:Home,
        name:'home'
    },
    {
        path:'/login',
        component:Login,
        name:'login'
    },
    {
        path:'/register',
        component:Register,
        name:'register'
    }

]

//创建路由
const router=createRouter({
    //采用history模式,摆脱了url中的#号，使得url更加美观
    history:createWebHistory('/'),
    routes:routes
})

export default router;