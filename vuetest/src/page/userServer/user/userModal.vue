<template>
  <div>
    <el-dialog
      :visible.sync="dialogVisible"
      :title="diaTitle"
      @close="close()">
      <el-form :model="this.data" ref="formName"  :rules="rules" >
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="data.userName"></el-input>
        </el-form-item>
        <el-form-item v-show="isShow" label="账号">
          <el-input v-model="data.account"></el-input>
        </el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item v-show="isShow" label="是否可用">
              <el-checkbox v-model="data.enabled" :disabled="isVisible">是</el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-show="isShow" label="是否过期">
              <el-checkbox v-model="data.notExpired"  :disabled="isVisible">是</el-checkbox>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item v-show="isShow" label="是否锁定">
              <el-checkbox v-model="data.accountNotLocked"  :disabled="isVisible">是</el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item v-show="isShow"  label="证书是否过期">
              <el-checkbox  v-model="data.credentialsNotExpired"  :disabled="isVisible">是</el-checkbox>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item v-show="isShow" label="创建时间">
          <el-input v-model="data.createTime" :disabled="isVisible"></el-input>
        </el-form-item>
        <el-form-item v-show="isShow" label="修改时间">
          <el-input v-model="data.updateTime" :disabled="isVisible"></el-input>
        </el-form-item>
        <el-form-item v-show="isShow" label="创建人">
          <el-input v-model="data.createUser" :disabled="isVisible"></el-input>
        </el-form-item>
        <el-form-item  v-show="isShow" label="修改人">
          <el-input v-model="data.updateUser" :disabled="isVisible"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="data.email"></el-input>
        </el-form-item>


        <el-form-item>
          <el-button type="primary" @click="submitForm('formName')">{{this.isVisible?"修改":"新建"}}</el-button>
          <el-button @click="resetForm('formName')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import {addUser} from '../../../config/getData'
  import {handleResponse} from '../../../utils/dateUtils'
    export default {
        name: "userModal",
      data(){
          return{
            dialogVisible:false,//控制该modal的显示隐藏
            isVisible:true,//控制持有该属性的标签是否可操作
            diaTitle:'',//标题（根据传入的数据赋值）
            isShow:false,//控制持有该属性的标签是否显示
            //modal数据
            data: {},
            //表单校验规则
            rules: {
              userName: [
                { required: true, message: '请输入用户名', trigger: 'blur' }
              ],
              email: [
                { pattern: /^[a-zA-Z]\w{5,17}@163.com/, message: '请输入正确的邮箱', trigger: 'blur'}
              ],
            }
          }
      },
      methods:{
        // 新增
        openModal(val) {
          this.dialogVisible = true;//显示
          if (val!=='新建用户'){
            this.diaTitle = "修改";//显示标题
            this.isVisible=true;
            this.isShow=true;
            this.data = val;
          } else {
            this.data={};
            this.diaTitle = "新建";//显示标题
            this.isVisible=false;
            this.isShow=false;
          }
        },
        //新增按钮
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              let formData = this.data;
              formData.createUser=JSON.parse(localStorage.getItem('userInfo')).username;
              addUser(formData)
                .then(res=>{
                  this.dialogVisible=false;
                  handleResponse(res);
                  this.$parent.initData(1,10);
                })
            } else {
              return false;
            }
          });
        },
        //关闭回调，刷新父组件
        close(){
          this.$parent.initData(1,10);
        },
        //重置
        resetForm(formName) {
          this.$refs[formName].resetFields();
        },
      }
    }
</script>

<style scoped>

</style>
