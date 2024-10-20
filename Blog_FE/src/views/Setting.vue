<template>
    <div class="personal-center">
      <aside class="sidebar">
        <ul>
          <li>
            <el-button 
             type="text" @click="displayProfile"> 展示个人资料</el-button>
          </li>
          <li>
            <el-button type="text" @click="showChangePasswordDialog">修改密码</el-button>
          </li>
          <li>
            <el-button type="text" @click="changeBackground">更改主背景</el-button>
          </li>
          <li>
            <router-link to="/">返回首页</router-link>
          </li>
        </ul>
      </aside>
      <div class="content">
        <router-view></router-view>
      </div>

      <el-dialog title="个人资料" :visible.sync="profileVisible">
       
        <div>
         <div>
            <p>账号：{{ user.account }}</p>
         </div> 
         <div>
            <p>昵称：{{ user.nickname }}</p>
         </div>
          <img :src="user.avatar" alt="头像" class="avatar">
        </div>
      </el-dialog>

      <el-dialog title="修改密码" :visible.sync="passwordVisible">
        <el-form :model="passwordForm">
          <el-form-item label="旧密码">
            <el-input type="password" v-model="passwordForm.oldPassword"></el-input>
          </el-form-item>
          <el-form-item label="新密码">
            <el-input type="password" v-model="passwordForm.newPassword"></el-input>
          </el-form-item>
          <el-form-item label="确认新密码">
            <el-input type="password" v-model="passwordForm.confirmPassword"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="passwordVisible = false">取消</el-button>
          <el-button type="primary" @click="updatePassword">确认修改</el-button>
        </span>
      </el-dialog>
      <template>
</template>

    </div>
 

  </template>

  



  <script>
  export default {
    name: "个人中心",
    data() {
      return {
        profileVisible: false,
        passwordVisible: false,
        passwordForm: {
          oldPassword: '',
          newPassword: '',
          confirmPassword: ''
        },
        user: {
          account: 'xiaowang',
          nickname: 'xiaowang',
          avatar: "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
        },
        currentBackgroundIndex: 0,
        backgrounds: [
          'static/img/bg4.png',
          'static/img/background.png',
          'static/img/bg2.png',
          'static/img/bg3.png'
        ]
      };
    },
    mounted(){
      this.account=localStorage.getItem('username');
    },
    created() {
      this.getUserInfo();
    },
    methods: {
      // getUserInfo() {
      //   const token = getToken(); // 提供获取token的方式
      //   this.$http({
      //     headers: {'Authorization': token},
      //     url: '/users/currentUser',
      //     method: 'get'
      //   })
      //   .then(response => {
      //     this.user = response.data;
      //   })
      //   .catch(error => {
      //     console.log(error);
      //   });
      // },
      displayProfile() {
        this.profileVisible = true;
      },
      showChangePasswordDialog() {
        this.passwordVisible = true;
      },
      updatePassword() {
        if (this.passwordForm.newPassword !== this.passwordForm.confirmPassword) {
          this.$message.error('新密码和确认密码不一致');
          return;
        }
        this.$http.post('/api/update-password', this.passwordForm)
          .then(response => {
            this.$message.success('密码修改成功');
            this.passwordVisible = false;
          })
          .catch(error => {
            this.$message.error('密码修改失败');
          });
      },
      changeBackground() {
        this.currentBackgroundIndex = (this.currentBackgroundIndex + 1) % this.backgrounds.length;
        const body = document.body;
        body.style.backgroundImage = `url(${this.backgrounds[this.currentBackgroundIndex]})`;
        body.style.backgroundAttachment = 'fixed';
      }
    }
  }
  </script>






  <style scoped>
  .personal-center {
    display: flex;
  }
  .sidebar {
    width: 200px;
    background-color: #f4f4f4;
    min-height: 100vh;
    padding: 20px;
  }
  .sidebar ul {
    list-style: none;
  }
  .sidebar li {
    margin-bottom: 10px;
  }
  .sidebar a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
    display: block;
  }
  .sidebar a.router-link-active {
    color: #42b983;
  }
  .content {
    flex: 1;
    padding: 20px;
  }
  .avatar {
    width: 100px;
    height: 100px;
    border-radius: 50%;
  }
  </style>