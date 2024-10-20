<template>
  <el-card class ="rounded-card ">
    <div slot="header" class="me-tag-header">
      <el-button @click="toggleCollapse">{{ isCollapse ? '展开' : '收起' }}</el-button>
      <span><i class="el-icon-share"></i>&nbsp;热门标签</span>
      <a @click="moreTags" class="me-pull-right me-tag-more">All</a>
    </div>

    <el-collapse v-model="activeNames" @change="handleChange">
      <el-collapse-item title="热门标签" name="1">
        <ul class="me-tag-list">
          <li class="me-tag-item" v-for="t in tags" :key="t.id">
            <el-button @click="tag(t.id)" size="mini" type="primary" round plain>{{ t.tagName }}</el-button>
          </li>
        </ul>
      </el-collapse-item>
    </el-collapse>
  </el-card>
</template>

<script>
export default {
  name: 'CardTag',
  props: {
    tags: Array
  },
  data() {
    return {
      activeNames: ['1'],
      isCollapse: false
    };
  },
  methods: {
    moreTags() {
      this.$router.push('/tag/all');
    },
    tag(id) {
      this.$router.push({ path: `/tag/${id}` });
    },
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
      this.activeNames = this.isCollapse ? [] : ['1'];
    },
    handleChange(value) {
      // 处理折叠变化时的逻辑
    }
  }
};
</script>

<style scoped>
.me-tag-header {
  font-weight: 600;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.me-tag-more {
  font-size: 14px;
  color: #78b6f7;
}

.me-tag-list {
  list-style-type: none;
  padding: 0;
}

.me-tag-item {
  display: inline-block;
  padding: 4px;
  font-size: 14px;
  color: #5FB878;
}

.me-tag-item a:hover {
  text-decoration: underline;
}

.rounded-card {
  border-radius: 20px; /* 圆润的棱角 */
  border: 1px solid #314676; /* 精致的边框 */
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1); /* 添加阴影以增强立体感 */
}
</style>