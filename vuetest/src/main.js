// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import ElementUI from 'element-ui' //新添加
import 'element-ui/lib/theme-chalk/index.css' //新添加，避免后期打包样式不同，要放在import App from './App';之前
import Vue from 'vue'
import App from './App'
import router from './router/index'//路由
import store from './vuex/store'//store
import less from 'less'
import {has} from './utils/checkPermission'//自定义属性，用来检查权限
Vue.use(less)
Vue.use(ElementUI)
Vue.use(has)
Vue.config.productionTip = false



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>',
  methods:{
  }
})
