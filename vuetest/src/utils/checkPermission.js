import Vue from 'vue';
import {permissionHandel,permissionAllHandel} from './dateUtils'


//增加v-has属性
const has = Vue.directive('has',
  {
    bind:function (el,binding) {
      let value = binding.expression.split('\'')[1];
      if (!Vue.prototype.$_has(value)) {
        el.style.display='none';
      }
    }
  });


//判断当前用户是否包含按钮相应的权限
Vue.prototype.$_has=(v)=>{
  let isExit = false;
  let item = JSON.parse(localStorage.getItem('userInfo'));
  let permissions = permissionHandel(item);
  let isPermissionAll = permissionAllHandel(permissions);
  if (isPermissionAll){
    isExit=true;
  }else {
    for (let i=0 ; i<permissions.length ; i++){
      if (permissions[i].permissionCode===v){
        isExit=true;
        break;
      }
    }
  }

  return isExit;
}

export {has};
