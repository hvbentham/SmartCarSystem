<template>
  <el-container style="min-height: 100vh">
    <Aside></Aside>
    <el-main>
      <div>主页</div>
    </el-main>
  </el-container>
</template>

<script>
import Aside from "@/components/Aside";
export default {
  name:"Home",
  components: {Aside}
}
</script>

<style scoped>

</style>
