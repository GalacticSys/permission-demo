<template>

  <div>
    <el-container>
      <!--<el-header>Header</el-header>-->
      <el-row style="height: 60px;line-height: 60px">
        <el-col :span="16" style="text-align: left">
          权限管理demo
        </el-col>
        <el-col :span="8" style="text-align: right;padding-right: 20px">
          <el-dropdown placement="bottom-end">
            <span>
              <el-button class="el-icon-arrow-down el-icon-user" :circle="true"></el-button>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>用户信息</el-dropdown-item>
              <el-dropdown-item> <el-link @click="logOut" style="width: 100%" type="danger">退出</el-link></el-dropdown-item>
            </el-dropdown-menu>

          </el-dropdown>
        </el-col>
      </el-row>
      <el-container>
        <el-aside>
          <el-row style="height: 100%;">
              <el-menu  class="el-menu-vertical-demo" router @open="handleOpen" @close="handleClose" :collapse="isCollapse">
                <el-menu-item index="/home"><i class="el-icon-menu"></i>首页</el-menu-item>
                  <el-submenu :index="''+menu.menuId" v-for="menu in menuList" :key="menu.menuId">
                    <template slot="title">
                      <span slot="title">{{menu.menuName}}</span>
                    </template>
                    <el-menu-item :index="item.menuPath" v-for="item in menu.children" :key="item.menuId">
                      {{item.menuName}}
                    </el-menu-item>
                  </el-submenu>
                <!--<el-submenu index="2">-->
                  <!--<template slot="title"><i class="el-icon-plus"></i><span slot="title">添加数据</span></template>-->
                  <!--<el-menu-item index="userList">添加用户</el-menu-item>-->
                  <!--<el-menu-item index="roleList">添加角色</el-menu-item>-->
                  <!--<el-menu-item index="permissionList">添加权限</el-menu-item>-->
                <!--</el-submenu>-->
              </el-menu>
          </el-row>
        </el-aside>
        <el-main>
          <keep-alive>
            <router-view></router-view>
          </keep-alive>
        </el-main>
      </el-container>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>
  import {logout} from '../config/getData'
  export default {
    name: "index",
    data() {
      return {
        msg: '',
        isCollapse: false,
        menuList:[],
        userList: []
      };
    },
    computed: {
    },
    created(){
      this.getMenus();
    },
    methods: {
      handleOpen(key, keyPath) {
      },
      handleClose(key, keyPath) {
      },
      getMenus(){
        let menu = JSON.parse(localStorage.getItem('myMenu'));
        this.menuList = menu;
      },
      logOut(){
        this.$alert('are you logOut???','', {
          confirmButtonText: '确定',
          callback: action => {
            if (action === 'confirm') {
              localStorage.clear();
              logout();
              this.$router.push({ path: '/login' })
            }
          }
        });
      },
    }
  }
</script>

<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    width: 100%;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    line-height: 200px;
    height: 100%;
    width: 30%;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    height: 100%;
  }

  body > .el-container {
    margin-bottom: 40px;
  }
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 99%;
    min-height: 100%;
    text-align: left;
  }
  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>
