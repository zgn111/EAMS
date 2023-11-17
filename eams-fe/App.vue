<script>
import Home from "@/view/Home.vue";
import Login from "@/view/Login.vue";
import Register from "@/view/Register.vue";

export default {
  name: "App",
  components: {
    Home,
    Login,
    Register,
  },
};
</script>

<template>
<router-view></router-view>
</template>

