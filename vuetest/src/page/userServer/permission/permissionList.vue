<template>
    <div>
      <el-row>
        <el-col :span="12"><head-top/></el-col>
        <el-col :span="12" style="text-align: right;padding-right: 5px">
          <el-button type="primary" v-has="'create_permission'" @click="openModel('新建权限')">新增</el-button>
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
          prop="permissionCode"
          label="权限编码"
          width="100%">
        </el-table-column>
        <el-table-column
          prop="permissionName"
          label="权限名"
          width="100%">
        </el-table-column>
        <el-table-column
          label="操作"
          width="150%">
          <template slot-scope="scope">
          <!--<el-button type="text" size="mini" v-has="'AssigRoles_action'">分配角色</el-button>-->
          <el-button
            type="danger"
            size="mini"
            icon="el-icon-delete"
            circle
            v-has="'delete_permission'"
            @click="deletePermission(scope.$index, scope.row)">
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
        <permissionModal ref="permissionModal"/>
      </div>
    </div>
</template>

<script>
  import headTop from '../../../components/headTop'
  import {getPermissionList,deletePermission} from '../../../config/getData'
  import permissionModal from './permissionModal'
  import {dateFtt,handleResponse,handleResponseTwo} from '../../../utils/dateUtils'
  import transfer from '../../../transfer/transfer'
    export default {
        name: "permissionList",
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
      components: {
        'headTop':headTop,
        'permissionModal':permissionModal,
      },
      //用于数据初始化
      created: function () {
        this.initData(this.paging.currentPage,this.paging.pageSize);
      },
      methods:{
        initData( page,count) {
          let params ={
            "start":page,
            "rows":count,
          };
          getPermissionList(params)
            .then(res => {
              let data = handleResponseTwo(res);
              if (data.code === "200") {
                this.paging.tableData = data.data.list;
                this.paging.totalCount=data.data.total;
              }
            })

        },

        //通过id删除权限
         deletePermission(index,row){
          this.$confirm('此操作将永久删除该权限, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then( () => {
             deletePermission({'permissionId': row.permissionId})
              .then((res) => {
                handleResponse(res);
                this.initData(this.paging.currentPage, this.paging.pageSize);
                transfer.$emit("assignPermission",'msg')
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
        //打开modal模态框
        openModel(val){
          this.$refs.permissionModal.openModal(val);
        },
      }
    }
</script>

<style scoped>

</style>
