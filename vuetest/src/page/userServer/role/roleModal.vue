<template>
  <el-dialog
    :visible.sync="dialogVisible"
    :title="diaTitle"
    @close="close()">
    <el-form :model="data" ref="formName"  :rules="rules" >
      <el-form-item label="角色名" prop="roleName">
        <el-input v-model="data.roleName"></el-input>
      </el-form-item>
      <el-form-item label="角色说名" prop="roleDescription">
        <el-input v-model="data.roleDescription"></el-input>
      </el-form-item>
      <el-form-item label="角色编码" prop="roleCode">
        <el-input v-model="data.roleCode" ></el-input>
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
</template>

<script>
  import {addRole} from '../../../config/getData'
  import {handleResponse} from '../../../utils/dateUtils'
  import transfer from '../../../transfer/transfer'
    export default {
        name: "roleModal",
      data(){
          return{
            dialogVisible:false,
            isVisible:true,
            diaTitle:'',
            data:{},
            //表单校验规则
            rules: {
              roleName: [
                { required: true, message: '请输入用户名', trigger: 'blur' }
              ],
              email: [
                { pattern: /^[a-zA-Z]\w{5,17}@163.com/, message: '请输入正确的邮箱', trigger: 'blur'}
              ],
            }
          }
      },
      methods:{
        // 打开modal
        openModal(val) {
          this.dialogVisible = true;//显示
          if (val!=='新建用户'){
            this.diaTitle = "修改";//显示标题
            this.isVisible=true;//根据传入参数判断checkBox是否可选
            this.data = val;
          } else {
            this.data={};
            this.diaTitle = "新建";//显示标题
            this.isVisible=false;//根据传入参数判断checkBox是否可选
          }
        },

        //添加角色
        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              let formData = this.data;
              addRole(formData)
                .then(res=>{
                  this.$parent.initData(1,10);
                  this.dialogVisible=false;
                  handleResponse(res);
                  //添加成功后，调用分配角色中的获取所有角色方法
                  transfer.$emit('assignRoles', 'msg')
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

        //重置按钮
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
</script>

<style scoped>

</style>
