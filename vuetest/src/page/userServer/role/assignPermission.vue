<template>
  <el-dialog :visible.sync="dialogVisible" :title="title">
    <el-transfer
      style="text-align: left;margin-left: 70px"
      :titles="titles"
      @right-check-change="checkRightValue"
      @change="checkValue"
      v-model="value"
      :data="data">
    </el-transfer>
    <el-button type="primary" size="mini" @click="assignPermission()">确定</el-button>
    <el-button type="primary" size="mini" @click="closeAssignPermission()">取消</el-button>
  </el-dialog>
</template>

<script>

  import {getPermissionList,queryByRoleId,assignPermission} from '../../../config/getData'
  import {handleResponse,handleResponseTwo} from '../../../utils/dateUtils'
  import transfer from '../../../transfer/transfer'

  export default {
    name:"assignPermission",
    data() {
      return {
        roleId:'',
        data: [],
        value: [],
        title:"分配权限",
        titles:['所有权限',],
        dialogVisible:false,
      };
    },
    created: async function () {
      this.initData(0,0);
    },
    //删除权限和新增权限时，刷新分配权限的获取所有权限方法
    mounted(){
      let that = this;
      transfer.$on('assignPermission', function(msg) {
        that.initData(0,0)
      })
    },
    methods:{
      //获取初始数据
      async initData(start,row){
        let params = {
          'start':start,
          'rows':row
        };
        //获取所有权限
        let permissionList = [];
        await getPermissionList(params)
          .then(res=>{
            //封装判断返回数据是否正确
            let data = handleResponseTwo(res);

            data.data.list.map(permission=>{
              permissionList.push({
                'key':permission.permissionId,
                'label':permission.permissionName,
                'disabled':false
              })
            });
            this.data = permissionList;
          })
      },

      //(右边数据发生变化时进入此方法)我的角色至少一个
      checkRightValue(value, direction, movedKeys){
        if ((this.value.length - value.length) === 1) {
          this.value.map(
            val=>{
              if (this.indexOf(val,value)===-1){
                this.data[val-1].disabled=true;
              }
            }
          )
        }
      },

      //(数据发生变化时进入此方法)
      checkValue(){
        if (this.value.length>1){

          this.data.map(d=>{
            d.disabled=false;
          })
        }
      },
      //判断某个数组是否包含某个元素
      indexOf(val,list){
        for (let i=0;i<list.length;i++){
          if (list[i].toString()==val.toString()){
            return i;
          }
        }
        return -1;
      },
      //分配权限
      assignPermission(){
        this.dialogVisible=false;
        let permissionIds = new Array();
          this.value.map(val=>{
            permissionIds.push({
              'roleId':this.roleId,
              'permissionId':val
            })
        });
        if (permissionIds.length != 0) {
          assignPermission(permissionIds)
            .then(res=>{
              //封装判断返回数据是否正确
              handleResponse(res);
            })
        }else {
          this.$notify.error({
            title: '错误',
            message: '该角色权限至少为一个',
            offset: 100
          });
        }
      },
      //设置list中某个值的disabled属性为true,val是list中的key属性的值
      disabledIsTrue(list , val){
        list.map(l=>{
          if (l.key===val){
            l.disabled=true;
          }
        })
      },
      //打开当前模态框
      async openAssignRoles(role){
        //获取当前行角色所拥有的所有权限
        let value = [];
        await queryByRoleId({'roleId':role.roleId})
          .then(res=>{
            res.data.map(myPermission=>{
              this.data.map(permission=>{
                if (myPermission.permissionId===permission.key){
                  value.push(myPermission.permissionId)
                }
              })
            })
          });
        if (value.length===1){
          this.disabledIsTrue(this.data,value[0]);
        }
        this.dialogVisible=true;
        this.value=value;
        this.roleId=role.roleId;
        this.titles[1]=role.roleName+"的权限"
      },
      //关闭模态框
      closeAssignPermission(){
        this.dialogVisible=false;
      }
    }
  };
</script>

<style scoped>
</style>
