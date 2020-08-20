import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const store = new Vuex.Store({

  state: {
    // 存储token
    Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : '',
    //当前登录的用户信息及权限
    userInfo: localStorage.getItem('userInfo') ? localStorage.getItem('userInfo') : '',
    //当前登录的菜单列表
    myMenu: localStorage.getItem('myMenu') ? localStorage.getItem('myMenu') : '',
  },

  mutations: {
    // 修改token，并将token存入localStorage
    changeLogin (state, token) {
      state.Authorization = token.Authorization;
      localStorage.setItem('Authorization',token.Authorization);
    },
    // 将当前用户信息存入localStorage
    setUserInfo (state, user) {
      state.userInfo = user.user;
      localStorage.setItem('userInfo',JSON.stringify(user.user));
    },
    // 当前登录的菜单列表
    setMyMenu (state, menu) {
      state.userInfo = menu.menu;
      localStorage.setItem('myMenu',JSON.stringify(menu.menu));
    },
  }
});

export default store;
