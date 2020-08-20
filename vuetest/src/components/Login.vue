<template>
    <div>
      <el-form style="margin-top: 200px;text-align: center" :model="info" :role="rules" ref="loginFormRefTwo" class="login_form">
        <el-form-item prop="username" style="margin-left: 25px">
          name:<el-input style="width: 20%" v-model="info.username" prefix-icon="el-icon-solid"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          password:<el-input type="password" style="width: 20%" v-model="info.password"></el-input>
        </el-form-item>
        <el-form-item prop="buttons">
          <el-button type="primary" @click="onsubmit('loginFormRefTwo')" :loading="loadingBtn">登录</el-button>
          <!--<el-button type="info" @click="restart">重置</el-button>-->
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
  import { mapMutations } from 'vuex';
  import {login} from '../config/getData'
  import {handleResponse} from '../utils/dateUtils'
  export default {
    name: 'Login',
    data(){
      return{
        info:{username:"用户1",password:"123456"},
        rules: {
          username: [
            { required: true, message: '请输入用名', trigger: 'blur' },
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' }
          ],
        },
        loadingBtn: false,
      };
    },

    methods:{
      ...mapMutations(['changeLogin','setUserInfo','setMyMenu']),
      onsubmit(formName){
        this.loadingBtn=true;
        this.$refs[formName].validate(valid=>{
         let formData = new FormData();
         formData.append("username",this.info.username);
         formData.append("password",this.info.password);
         let userInfo ={
             "username":this.info.username,
             "password":this.info.password
           };
         if (valid){
           login(userInfo)
             .then(res=>{
               let data = handleResponse(res);
               // let myMenus = myMenuHandel(data.data.sysUser);
               this.loadingBtn=false;
               this.userToken = 'Bearer ' + data.token;
               this.changeLogin({ Authorization: this.userToken });
               this.setUserInfo({user:data.data.sysUser});
               this.setMyMenu({menu:data.data.sysUser.sysMenus});
               this.$router.push({
                     path:'/menu'
                   })
           })
         } else {
           this.loadingBtn=false
           this.$notify.error({
             title: '错误',
             message: '请输入正确的用户名密码',
             offset: 100
           });
           return false;
         }
       })//validate
       },//onsubmit

    }//methods
  }
</script>

<style scoped>

</style>
