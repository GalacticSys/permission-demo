<template>
  <el-dialog :visible.sync="dialogVisible" :title="title" :close-on-click-modal="false":destroy-on-close="true" :before-close="closeAssignRoles">
    <el-transfer
      style="text-align: left;margin-left: 70px"
      :titles="['角色列表', '我的角色']"
      @right-check-change="checkRightValue"
      @change="checkValue"
      v-model="value"
      :data="data">
    </el-transfer>
    <el-button type="primary" size="mini" @click="assignRoles()">确定</el-button>
    <el-button type="primary" size="mini" @click="closeAssignRoles()">取消</el-button>
  </el-dialog>
</template>

<script>

  import {getRoleList,queryAllByUserId,assignRoles} from '../../../config/getData'
  import {handleResponse,handleResponseTwo} from '../../../utils/dateUtils'
  import transfer from '../../../transfer/transfer'
  export default {
    name:"assignRoles",
    data() {
      return {
        userId:'',
        data: [],
        value: [],
        title:"分配角色",
        dialogVisible:false,
      };
    },

    created: async function () {
      this.initData(0,0);

    },
    //删除角色和新增角色时，刷新分配角色的获取所有角色方法
    mounted(){
      let that = this;
      transfer.$on('assignRoles', function(msg) {
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
        //获取所有角色
        let roleList = [];
        await getRoleList(params)
          .then(res=>{
            //封装判断返回数据是否正确
            let data = handleResponseTwo(res);
            if (data!=null){
              data.data.list.map(role=>{
                roleList.push({
                  'key':role.roleId,
                  'label':role.roleName+'',
                  'disabled':false
                })
              });
            }
            this.data = roleList;
          })
      },

      //(右边数据发生变化时进入此方法)我的角色至少一个
      checkRightValue(value, direction, movedKeys){
        if ((this.value.length - value.length) === 1) {
          this.value.map(
            val=>{
              if (this.indexOf(val,value)===-1){
                this.disabledIsTure(this.data,val);
              }
            }
          )
        }else {
          this.data.map(d=>{
            d.disabled=false;
          })
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
      assignRoles(){
        this.dialogVisible=false;
        let roleIds = new Array();
          this.value.map(val=>{
            roleIds.push({
              'userId':this.userId,
              'roleId':val
            })
        });
        if (roleIds.length != 0) {
          assignRoles(roleIds)
            .then(res=>{
              //封装判断返回数据是否正确
              handleResponse(res);
            })
        }else {
          this.$notify.error({
            title: '错误',
            message: '我的角色至少为一个',
            offset: 100
          });
        }
      },
      //打开当前模态框
      async openAssignRoles(user){
        //获取当前行用户所拥有的所有角色
        let value = [];
        await  queryAllByUserId({'uId':user.userId})
          .then( res=>{
            res.data.map( myRole=>{
              this.data.map(role=>{
                if (myRole.roleId===role.key){
                  value.push(myRole.roleId)
                }
              })
            })
          });
        this.value=value;
        this.userId=user.userId;
        this.dialogVisible=true;
        this.data.map(d=>{
          d.disabled=false
        })
        if (value.length===1){
          this.disabledIsTrue(this.data,value[0]);
        }
      },
      //关闭模态框
      closeAssignRoles(){
        this.dialogVisible=false;
        this.value=[];
      },
    }
  };
</script>

<style scoped>
</style>
