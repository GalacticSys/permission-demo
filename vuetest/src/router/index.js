import Vue from 'vue'
import Router from 'vue-router'
import {permissionHandel,permissionAllHandel} from '../utils/dateUtils'
import store from '../vuex/store'
Vue.use(Router)
const routes =[
      {
        path: '/',
        redirect:'login'
      },
      {
        path: '/login',
        name: 'Login',
        component:  resolve => require(['@/components/Login'], resolve),
      },
  {
    path: '/menu',
    name: 'menu',
    component: resolve => require(['@/page/menu'], resolve),
    children: [
      {
        path: '/home',
        name: 'home',
        component: resolve => require(['@/page/home'], resolve),
      },
      {
        path: '/query_user',
        name: 'query_user',
        component: resolve => require(['@/page/userServer/user/userList'], resolve),
        meta: ['数据管理', '用户信息'],
      },
      {
        path: '/query_role',
        name: 'query_role',
        component: resolve => require(['@/page/userServer/role/roleList'], resolve),
        meta: ['数据管理', '角色信息'],
      },
      {
        path: '/query_permission',
        name: 'query_permission',
        component: resolve => require(['@/page/userServer/permission/permissionList'], resolve),
      },
      {
        path:'/query_goods',
        name:'query_goods',
        component:resolve => require(['@/page/goodsServer/goods/goodsList.vue'], resolve),
      },
      {
        path:'/query_category',
        name:'query_category',
        component:resolve => require(['@/page/goodsServer/goods/categoryList.vue'], resolve),
      },
      {
        path:'/query_brand',
        name:'query_brand',
        component:resolve => require(['@/page/goodsServer/goods/brandList.vue'], resolve),
      },
    ]
  },
    ];

export const asyncRouters=[
  {
    path: '/menu',
    name: 'menu',
    component: resolve => require(['@/page/menu'], resolve),
    children: [
      {
        path: '/home',
        name: 'home',
        component: resolve => require(['@/page/home'], resolve),
      },
      {
        path: '/query_user',
        name: 'query_user',
        component: resolve => require(['@/page/userServer/user/userList'], resolve),
        meta: ['数据管理', '用户信息'],
      },
      {
        path: '/query_role',
        name: 'query_role',
        component: resolve => require(['@/page/userServer/role/roleList'], resolve),
        meta: ['数据管理', '角色信息'],
      },
      {
        path: '/query_permission',
        name: 'query_permission',
        component: resolve => require(['@/page/userServer/permission/permissionList'], resolve),
      },
      {
        path:'/query_goods',
        name:'query_goods',
        component:resolve => require(['@/page/goodsServer/goods/goodsList.vue'], resolve),
      },
      {
        path:'/query_category',
        name:'query_category',
        component:resolve => require(['@/page/goodsServer/goods/categoryList.vue'], resolve),
      },
      {
        path:'/query_brand',
        name:'query_brand',
        component:resolve => require(['@/page/goodsServer/goods/brandList.vue'], resolve),
      },
    ]
  },


];
const router = new Router({

  mode:'history',
  routes
});
export default router;
// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，
router.beforeEach((to, from, next) => {
//判断是否是登录路径若是放行
  if (to.path === '/login') {
    next();
  } else {
    //获取登陆后接收的token
    let token = localStorage.getItem('Authorization');
    //判断用户是否登陆
    if (token === 'null' || token === '') {
      next('/login');
    } else {
      if (localStorage.getItem('router')==null){
      }
      next();
    }
  }
});

