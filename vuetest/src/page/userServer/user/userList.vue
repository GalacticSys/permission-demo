<template>
  <div>
    <el-row>
      <el-col :span="12"><head-top/></el-col>
      <el-col :span="12" style="text-align: right;">
        <el-button type="primary" v-has="'create_user'" @click="openModel('新建用户')">新增</el-button>
        <el-button type="primary" @click="restart()">刷新</el-button>
      </el-col>
    </el-row>
    <el-table
      :data="paging.tableData"
      style="margin-top: 10px"
      width="90%"
      :row-style="{height: '0'}"
      :cell-style="{padding: '0'}"
      @row-dblclick="this.openModel"
      stripe>
      <el-table-column
        prop="userName"
        label="用户名"
        sortable
        width="100%">
      </el-table-column>
      <el-table-column
        prop="account"
        label="账号"
        width="100%">
      </el-table-column>

      <el-table-column
        prop="enabled"
        label="是否可用"
        sortable
        :formatter="isEnabled"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="notExpired"
        label="是否过期"
        :formatter="isExpired"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="accountNotLocked"
        :formatter="isLocked"
        label="是否锁定"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="credentialsNotExpired"
        :formatter="isCredentialsExpired"
        label="密码是否过期"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="createTime"
        :formatter="editDate"
        label="创建时间"
        sortable
        width="100%">
      </el-table-column>
      <el-table-column
        prop="updateTime"
        :formatter="editDate"
        label="修改时间"
        sortable
        width="100%">
      </el-table-column>
      <el-table-column
        prop="createUser"
        label="创建人"
        width="100%">
      </el-table-column>
      <el-table-column
        prop="updateUser"
        label="修改人"
        width="100%">
      </el-table-column>
      <el-table-column
        label="操作"
        width="150%">
        <template slot-scope="scope">
          <el-button
            type="text"
            size="mini"
            v-has="'assignRoles_action'"
            @click="openAssignRoles(scope.$index, scope.row)">分配角色
          </el-button>
          <el-button
            type="danger"
            size="mini"
            icon="el-icon-delete"
            circle v-has="'delete_user'"
            @click="deleteUser(scope.$index, scope.row)">

          </el-button>
        </template>

      </el-table-column>
    </el-table>
    <el-pagination @size-change="handleSizeChange"
                   @current-change="handleCurrentChange"
                   :current-page="paging.currentPage"
                   :page-sizes="paging.pageSizes"
                   :page-size="paging.pageSize" layout="total, sizes, prev, pager, next, jumper"
                   :total="paging.totalCount">
    </el-pagination>
     <div>
       <userModal ref="userModal"/>
     </div>
    <div>
      <assignRoles ref="assignRoles"/>
    </div>
  </div>
</template>

<script>
  import headTop from '../../../components/headTop'
  import userModal from './userModal'
  import assignRoles from './assignRoles'
  import {getUserList,deleteUser} from '../../../config/getData'
  import {dateFtt,handleResponse,handleResponseTwo} from '../../../utils/dateUtils'
    export default {
      name: "userList",
      components: {
        'headTop':headTop,
        'userModal':userModal,
        'assignRoles':assignRoles,
      },
      data() {
        return {
          msg: '',
          isCollapse: false,
          paging:{
            // 总数据
            tableData:[],
            // 默认显示第几页
            currentPage:1,
            // 总条数，根据接口获取数据长度(注意：这里不能为空)
            totalCount:1,
            // 个数选择器（可修改）
            pageSizes:[5,10,15,20],
            // 默认每页显示的条数（可修改）
            pageSize:10,
          }
        };
      },
      //用于数据初始化
      created: function () {
        this.initData(this.paging.currentPage,this.paging.pageSize);
      },
      methods: {
        //获取数据
        initData( page,count) {
          let params ={
              "start":page,
              "rows":count,
            };
          getUserList(params)
            .then(res => {
              let data = handleResponseTwo(res);
              if (data!=null){
                if (data.code === "200") {
                  this.paging.tableData = data.data.list;
                  this.paging.totalCount=data.data.total;
                }
              }
            })
        },

        //通过id删除用户
        deleteUser(index,row){
          this.$confirm('此操作将永久删除该用户, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
          }).then(() => {
            deleteUser({'userId':row.id})
              .then((res)=>{
                handleResponse(res);
                this.initData(0,10);
              })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        },

        //刷新
        restart(){
          this.initData(this.paging.currentPage,this.paging.pageSize);
        },
        //账号是否可用。默认为1（可用）
        isEnabled(row,column){
          return this.isTrue(row.enabled)

        },
        //是否过期。默认为0（没有过期）
        isExpired(row,column){
          return this.isTrue(row.notExpired)
        },
        //账号是否锁定。默认为0（没有锁定）
        isLocked(row,column){
          return this.isTrue(row.accountNotLocked)
        },
        //证书（密码）是否过期。默认为0（没有过期）
        isCredentialsExpired(row,column){
          return this.isTrue(row.credentialsNotExpired)
        },
        //修改时间显示格式
        editDate(row,column){
          if (row.createTime!=null){
            let date = new Date(row.createTime);
            return dateFtt("yyyy-MM-dd hh:mm:ss",date);
          }
        },
        // 分页
        // 每页显示的条数
        handleSizeChange(val) {
          // 改变每页显示的条数
          this.paging.pageSize=val
          // 点击每页显示的条数时，显示第一页
          this.initData(1,val)
          // 注意：在改变每页显示的条数时，要将页码显示到第一页
          this.paging.currentPage=1
        },
        // 显示第几页
        handleCurrentChange(val) {
          // 改变默认的页数
          this.paging.currentPage=val;
          // 切换页码时，要获取每页显示的条数
          this.initData(val,this.paging.pageSize)

        },

        //参数，为boolean值
        isTrue(b){
          if (b===true){
            return "是"
          }else {
            return "否"
          }
        },
        //打开新增模态框
        openModel(row, column, cell, event){
          this.$refs.userModal.openModal(row);
        },
        //打开分配角色模态框
        openAssignRoles(index,row){
          this.$refs.assignRoles.openAssignRoles(row);
        },
      }
    }
</script>

<style >
</style>
