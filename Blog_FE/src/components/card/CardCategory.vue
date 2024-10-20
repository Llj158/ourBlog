<template>
  <el-card :body-style="{ padding: '8px 18px' }">
    <div slot="header" class="me-category-header" @click="toggleCollapse">
      <span><i class="el-icon-share"></i>&nbsp;最新文章</span>
      <i class="el-icon-arrow-down" v-if="!isCollapse"></i>
      <i class="el-icon-arrow-up" v-if="isCollapse"></i>
    </div>

    <el-collapse v-model="activeName" class="category-collapse">
      <el-collapse-item title="最新文章列表" name="1">
        <ul class="me-category-list">
          <li class="me-category-item" v-for="item in articles" :key="item.id">
            <a @click="viewArticle(item.id)">{{ item.title }}</a>
          </li>
        </ul>
      </el-collapse-item>
    </el-collapse>
  </el-card>
</template>

<script>
export default {
  name: 'CardCategory',
  data() {
    return {
      isCollapse: true, // 控制折叠状态
      activeName: '1', // 激活的折叠面板名称
      articles: [
        { id: 1, title: '为什么程序员那么有钱' },
        { id: 2, title: '搭建element-ui的Vue前端工程操作' },
        // 更多文章...
      ],
    };
  },
  methods: {
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
    },
    viewArticle(id) {
      // 跳转到文章详情页面
      this.$router.push({ path: `/article/${id}` });
    },
  },
};
</script>

<style scoped>
.me-category-header {
  font-weight: 600;
  cursor: pointer; /* 添加点击效果 */
}

.me-category-header i {
  margin-left: 10px; /* 添加箭头图标的间距 */
  transition: transform 0.3s; /* 平滑过渡效果 */
}

.me-category-header i.el-icon-arrow-down {
  transform: rotate(0deg); /* 默认箭头方向 */
}

.me-category-header i.el-icon-arrow-up {
  transform: rotate(180deg); /* 折叠时箭头方向 */
}

.category-collapse {
  border-top: none; /* 移除折叠面板顶部的边框 */
}

.me-category-list {
  list-style-type: none;
  padding: 0;
}

.me-category-item {
  padding: 4px;
  font-size: 14px;
  color: #5FB878;
}

.me-category-item a:hover {
  text-decoration: underline;
}
</style>









<!-- <template>

  <el-card :body-style="{ padding: '8px 18px' }">
    <div slot="header" class="me-category-header">
      <span><i class="el-icon-share"></i>&nbsp;最新文章</span>
    </div>

    <ul class="me-category-list">
      <li class="me-category-item" v-for="l in 3" :key="l"><a>为什么程序员那么有钱为什么程序员那么有钱为什么程序员那么有钱</a></li>
      <li class="me-category-item" v-for="l in 3" :key="l"><a>搭建element-ui的Vue前端工程操作</a></li>

    </ul>
  </el-card>

</template>

<script>
  export default {
    name: 'CardCategory',
    data() {
      return {}
    },
    methods: {}
  }
</script>

<style scoped>

  .me-category-header {
    font-weight: 600;
  }

  .me-category-list {
    list-style-type: none;
  }

  .me-category-item {
    padding: 4px;
    font-size: 14px;
    color: #5FB878;
  }

  .me-category-item a:hover {
    text-decoration: underline;
  }
</style>  -->