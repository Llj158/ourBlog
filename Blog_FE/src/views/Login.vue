<template>
  <div id="login" v-title data-title="登录">
    <!--<video preload="auto" class="me-video-player" autoplay="autoplay" loop="loop">
          <source src="../../static/vedio/sea.mp4" type="video/mp4">
      </video>-->

    <div class="me-login-box me-login-box-radius">
      <h2 >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
          登&nbsp;录</h2>

      <el-form ref="userForm" :model="userForm" :rules="rules">
        <el-form-item prop="account">
          <div> 输入账号：</div>
       <el-input placeholder="用户名" v-model="userForm.account">
      
       </el-input>
        </el-form-item>
      
        <el-form-item prop="password">
         
        
          <div> 输入密码：</div>
          <el-input placeholder="密码" type="password" v-model="userForm.password"></el-input>
        </el-form-item>

        <el-form-item size="small" class="me-login-button">
        
          
        </el-form-item>
      </el-form>
      
          &nbsp;&nbsp;&nbsp;
            <el-button type="success" size="mini"  @click.native.prevent="login('userForm')">点击登录</el-button>
            <el-button type="warning" size="mini"   @click.native.prevent="resetForm('userForm')">点击重置</el-button>
            <el-button type="danger" size="mini"  @click.native.prevent="tohome">返回首页</el-button>

       

    </div>
  </div>
</template>

<script>
  export default {
    name: 'Login',
    data() {
      return {
        userForm: {
          account: '',
          password: ''
        },
        rules: {
          account: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      login(formName) {
        let that = this

        this.$refs[formName].validate((valid) => {
          if (valid) {

            that.$store.dispatch('login', that.userForm).then(() => {
          // 将token存入本地缓存中
              localStorage.setItem('username', that.userForm.account)  
              // 跳转到首页
              
                that.$router.go(-1)
            }).catch((error) => {
              if (error !== 'error') {
                that.$message({message: error, type: 'error', showClose: true});
              }
            })
          } else {
            return false;
          }
        });
      },
   
  resetForm(formName) {
    this.$confirm('确定重置输入吗？', '提示', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    }).then(() => {
      this.$refs[formName].resetFields();
    }).catch(() => {
      // 取消操作，不执行任何操作
    });
  },



      tohome() {
        this.$router.push('/')
      }
    }
  }
</script>

<style scoped>
  #login {
    min-width: 100%;
    min-height: 100%;
  }

  .me-video-player {
    background-color: transparent;
    width: 90%;
    height: 90%;
    object-fit: fill;
    display: block;
    position: absolute;
    left: 0;
    z-index: 0;
    top: 0;
  }

  .me-login-box {
    position: absolute;
    width: 300px;
    height: 280px;
    background-color:rgb(229, 217, 217);
    margin-top: 150px;
    margin-left: -180px;
    left: 50%;
    padding: 30px;
  }

  .me-login-box-radius {
    border-radius: 10px;
    box-shadow: 0px 0px 1px 1px rgba(161, 159, 159, 0.1);
  }

  .me-login-box h1 {
    text-align: center;
    font-size: 24px;
    margin-bottom: 20px;
    vertical-align: middle;
  }

  .me-login-design {
    text-align: center;
    font-family: 'Open Sans', sans-serif;
    font-size: 18px;
  }

  .me-login-design-color {
    color: #3e889a !important;
  }

  .me-login-button {
    text-align: center;
  }

  .me-login-button button {
    width: 100%;
  }

</style>
