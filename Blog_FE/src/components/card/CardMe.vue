<template>
  <el-card>
    <h1 class="me-author-name">BLOG</h1>
    <div class="me-author-description">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <span><i class="el-icon-location-outline"></i> &nbsp; 活着，就是场旅行</span>
    </div>
    <div class="me-author-tool">
      <i @click="showTool(qq)" :title="qq.title" class="iconfont icon-qq"></i><br>
      <span>42@qq.com</span>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'CardMe',
  data() {
    return {
      qq: { title: 'QQ', message: '42' },
    }
  },
  methods: {
    showTool(tool) {
      this.$message({
        duration: 0,
        showClose: true,
        dangerouslyUseHTMLString: true,
        message: '<strong>' + tool.message + '</strong>'
      });
    }
  }
}
</script>

<style scoped>
.me-author-name {
  text-align: center;
  font-size: 30px;
  border-bottom: 1px solid #5FB878;
}

.me-author-description {
  padding: 8px 0;
}

.me-icon-job {
  padding-left: 16px;
}

.me-author-tool {
  text-align: center;
  padding-top: 50px;
  padding-top: 10px;
}

.me-author-tool i {
  cursor: pointer;
  font-size: 30px;
}
</style>
