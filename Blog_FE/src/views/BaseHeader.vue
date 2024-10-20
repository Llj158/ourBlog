<template>
  <el-header class="me-area">
    <el-row class="me-header">

      <el-col :span="4" class="me-header-left">
        <router-link to="/" class="me-title">
          <img class="imglogo" src="../assets/img/logo.png" />
        </router-link>
      </el-col>

      <!-- <el-col v-if="!simple" :span="16">
        <el-menu :router=true menu-trigger="click" active-text-color="#5FB878" :default-active="activeIndex"
                 mode="horizontal">
          <el-menu-item index="/">首页</el-menu-item>
          <el-menu-item index="/category/all">文章分类</el-menu-item>
          <el-menu-item index="/tag/all">标签</el-menu-item>
          <el-menu-item index="/archives">文章归档</el-menu-item>

          <el-col :span="4" :offset="4">
            <el-menu-item index="/write"><i class="el-icon-edit"></i>写文章</el-menu-item>
          </el-col>

        </el-menu>
      </el-col> -->
      
      <el-col v-if="!simple" :span="16" 
      >
  <el-menu :router="true" menu-trigger="click" active-text-color="red" :default-active="activeIndex"
           mode="horizontal">
    <el-menu-item index="/" class="custom-menu-item">首页</el-menu-item>

  
  

    <!-- <el-menu-item index="/category/all" class="custom-menu-item">
      <i class="el-icon-share"></i>文章分类</el-menu-item>
    <el-menu-item index="/tag/all" class="custom-menu-item">
      <i class="el-icon-menu"></i>标签分类</el-menu-item> -->

    <el-menu-item index="/archives" class="custom-menu-item">
      <i class="el-icon-document"></i>文章归档</el-menu-item>

    <el-col :span="4" :offset="0">
      <el-menu-item index="/write" class="custom-menu-item"><i class="el-icon-edit"></i>写文章</el-menu-item>
    </el-col>
    <el-dropdown>
  <el-menu-item >
   <i class="el-icon-more"  ></i>  分类查看
  </el-menu-item>
  <el-dropdown-menu slot="dropdown">
    <el-dropdown-item>  
       <el-menu-item index="/category/all" class="custom-menu-item">
      <i class="el-icon-share"></i>文章分类</el-menu-item></el-dropdown-item>
      <el-menu-item index="/tag/all" class="custom-menu-item">
      &nbsp; &nbsp; &nbsp; <i class="el-icon-menu"></i>标签分类</el-menu-item>
    
  </el-dropdown-menu>
</el-dropdown>

  </el-menu>
</el-col>



      <template v-else>
        <slot></slot>
      </template>

      <el-col :span="4">
        <el-menu :router=true menu-trigger="click" mode="horizontal" active-text-color="#5FB878">

          <template v-if="!user.login">
            <el-menu-item index="/login">
            <el-button round type="success"icon="el-icon-check"
            size="mini"  >
               登录</el-button>
            </el-menu-item>
            <el-menu-item index="/register">
              <el-button round  icon="el-icon-edit" size="mini" type="warning">注册</el-button>
            </el-menu-item>
          </template>

          <template v-else>
            <el-col>
            <el-submenu index>
              <template slot="title">
                <img class="me-header-picture" :src="user.avatar"/>
              </template>

              <el-menu-item   @click.native.prevent="$router.push('/setting')" >     <i class="el-icon-setting"></i>个人设置</el-menu-item>
              <!-- <el-menu-item   @click.native.prevent="$router.push('/texte')" >     <i class="el-icon-setting"></i>个人展示</el-menu-item> -->
              <el-menu-item index @click="logout"><i class="el-icon-back"></i>退出</el-menu-item>
              
            </el-submenu>
            </el-col>
          </template>


        </el-menu>
      </el-col>

    </el-row>
  </el-header>
</template>

<script>
  export default {
    name: 'BaseHeader',
    props: {
      activeIndex: String,
      simple: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {}
    },
    computed: {
      user() {
        let login = this.$store.state.account.length != 0
        let avatar = this.$store.state.avatar
        return {
          login, avatar
        }
      }
    },
    methods: {
      logout() {
        let that = this
        this.$store.dispatch('logout').then(() => {
          this.$router.push({path: '/'})
        }).catch((error) => {
          if (error !== 'error') {
            that.$message({message: error, type: 'error', showClose: true});
          }
        })
      }
    }
  }
</script>

<style>
  .imglogo{
  padding-left: 100px;
  }
  .el-header {
    position: fixed;
    z-index: 1024;
    min-width: 100%;
    box-shadow: 0 2px 3px hsla(0, 0%, 7%, .1), 0 0 0 1px hsla(0, 0%, 7%, .1);

  }

  .me-title {
    margin-top: 10px;
    font-size: 24px;
  }

  .me-header-left {

    margin-top: 10px;
  }

  .me-title img {
    max-height: 2.4rem;
    max-width: 100%;
  }

  .me-header-picture {
    width: 36px;
    height: 36px;
    border: 1px solid #ddd;
    border-radius: 50%;
    vertical-align: middle;
    background-color: #3e889a;
  }

  /* 添加 */
  .custom-menu-item:hover {
  color: #b8b45f !important; /* 金色 */
}
</style>
