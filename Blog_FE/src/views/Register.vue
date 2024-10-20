<template>


  
  <div id="register" v-title data-title="注册">
    <!--<video preload="auto" class="me-video-player" autoplay="autoplay" loop="loop">
          <source src="../../static/vedio/sea.mp4" type="video/mp4">
      </video>-->

    <div class="me-login-box me-login-box-radius">
      <h1>注&nbsp;&nbsp;册</h1>

      <el-form ref="userForm" :model="userForm" :rules="rules">
        <el-form-item prop="account">
          <div>输入用户名：</div>
          <el-input placeholder="用户名" v-model="userForm.account"></el-input>
        </el-form-item>

        <el-form-item prop="nickname">
          <div>输入昵称：</div>
          <el-input placeholder="昵称" v-model="userForm.nickname"></el-input>
        </el-form-item>

        <el-form-item prop="password">
          <div>输入密码：</div>
          <el-input placeholder="密码" type="password" v-model="userForm.password"></el-input>
        </el-form-item>
        <!-- 确认密码 -->
        <el-form-item prop="confirmPassword">
  <div>再次输入密码：</div>
  <el-input placeholder="确认密码" type="password" v-model="userForm.confirmPassword"></el-input>
</el-form-item>
<!-- <el-form-item size="small" class="me-login-button">
          <el-button type="primary" @click.native.prevent="register('userForm')">注册</el-button>
        </el-form-item> -->
    
      </el-form>
      &nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;
         <el-button type="primary" @click.native.prevent="register('userForm')">注册</el-button>
 <!-- 重置 -->
        &nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="danger" @click.native.prevent="resetForm('userForm')">重置</el-button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="warning" @click.native.prevent="$router.push('/')">返回</el-button>



    </div>
  </div>






</template>

<script>
  import {register} from '@/api/login'
import BaseFooter from '../components/BaseFooter.vue';

  export default {
    name: 'Register',
    data() {
      return {
        userForm: {
          account: '',
          nickname: '',
          password: '',
          // 新增字段
          confirmPassword: '' // 新增字段
        },
        rules: {
          account: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ],
          nickname: [
            {required: true, message: '请输入昵称', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {max: 10, message: '不能大于10个字符', trigger: 'blur'}
            
          ],
          // 新增字段
          confirmPassword: [
        {required: true, message: '请再次输入密码', trigger: 'blur'},
        {validator: this.confirmPasswordValidator, trigger: 'blur'}
      ]
        }

      }
    },
    methods: {
         // 新增字段
         confirmPasswordValidator(rule, value, callback) {
    if (value !== this.userForm.password) {
      callback(new Error('两次输入密码不一致'));
    } else {
      callback();
    }
  },

      register(formName) {
        let that = this
        this.$refs[formName].validate((valid) => {
          if (valid) {

            that.$store.dispatch('register', that.userForm).then(() => {
              that.$message({message: '注册成功', type: 'success', showClose: true});
              that.$router.push({path: '/'})
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
    width: 350px;
    height: 500px;
    background-color: rgb(229, 217, 217);
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
