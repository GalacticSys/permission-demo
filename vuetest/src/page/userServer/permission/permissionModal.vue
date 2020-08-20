<template>
  <el-dialog
    :visible.sync="dialogVisible"
    :title="diaTitle"
    @close="close()">
    <el-form :model="data" ref="formName"  :rules="rules" >
      <el-form-item label="权限名" prop="roleName">
        <el-input v-model="data.permissionName"></el-input>
      </el-form-item>
      <el-form-item label="权限编码" prop="roleCode">
        <el-input v-model="data.permissionCode" ></el-input>
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
  import {addPermission} from '../../../config/getData'
  import {dateFtt,handleResponse} from '../../../utils/dateUtils'
  import transfer from '../../../transfer/transfer'
    export default {
        name: "permission",
      data(){
          return{
            dialogVisible:false,
            isVisible:true,
            diaTitle:'',
            data:{},
            //表单校验规则
            rules: {
              permissionName: [
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
          if (val!=='新建权限'){
            this.diaTitle = "修改";//显示标题
            this.isVisible=true;//根据传入参数判断checkBox是否可选
            this.data = val;
          } else {
            this.data={};
            this.diaTitle = "新建";//显示标题
            this.isVisible=false;//根据传入参数判断checkBox是否可选
          }
        },

        submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              let formData = this.data;
              addPermission(formData)
                .then(res=>{
                  this.$parent.initData(this.$parent.paging.currentPage,this.$parent.paging.pageSize);
                  this.dialogVisible=false;
                  handleResponse(res);
                  //添加成功，刷新分配权限的获取所有权限的方法
                  transfer.$emit("assignPermission",'msg')
                })
            } else {
              return false;
            }
          });
        },

        //关闭回调，刷新父组件
        close(){
          this.$parent.initData(this.$parent.paging.currentPage,this.$parent.paging.pageSize);
        },

        // 重置按钮
        resetForm(formName) {
          this.$refs[formName].resetFields();
        }
      }
    }
</script>

<style scoped>

</style>
