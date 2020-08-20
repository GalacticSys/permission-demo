import ElementUI from 'element-ui';
import Router from'../router/index'
export const dateFtt=(fmt,date)=>{
  var o = {
    "M+" : date.getMonth()+1,     //月份
    "d+" : date.getDate(),     //日
    "h+" : date.getHours(),     //小时
    "m+" : date.getMinutes(),     //分
    "s+" : date.getSeconds(),     //秒
    "q+" : Math.floor((date.getMonth()+3)/3), //季度
    "S" : date.getMilliseconds()    //毫秒
  };
  if(/(y+)/.test(fmt))
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
  for(var k in o)
    if(new RegExp("("+ k +")").test(fmt))
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
  return fmt;
}


//处理请求返回值，带提示
export const handleResponse=(res)=>{
  if(res.code==="500"){
    ElementUI.Message({
      type: 'error',
      message: res.msg
    })
    return null;
  }
  else if(res.code==="200"){
    ElementUI.Message({
      type: 'success',
      message: res.msg
    })
  }
  else if(res.code==="401"){
    ElementUI.Message({
      type: 'error',
      message: '请求资源不存在'
    })
    Router.push({
      path:'/'
    });
    return null;
  }
  else if(res.code==="403"){
    ElementUI.Message({
      type: 'error',
      message: res.msg
    })
    return null;
  }
  else if(res.code==="405"){
    ElementUI.Message({
      type: 'error',
      message: res.msg
    });
    Router.push({
      path:'/'
    });
    return null;
  }
  // if (res.token!=null){
  //   res.data.token=res.token;
  // }
  return res;
}

//处理请求返回值，不带提示
export const handleResponseTwo=(res)=>{
  if(res.code==="500"){
    ElementUI.Message({
      type: 'error',
      message: res.msg
    })
    return null;
  }
  else if(res.code==="200"){
  }
  else if(res.code==="404"){
    ElementUI.Message({
      type: 'error',
      message: '请求资源不存在'
    })
    return null;
  }
  else if(res.code==="403"){
    ElementUI.Message({
      type: 'error',
      message: res.msg
    })
    return null;
  }
  else if(res.code==="405"){
    ElementUI.Message({
      type: 'error',
      message: res.msg
    });
    Router.push({
      path:'/'
    });
    return null;
  }
  else if(res.code==="401"){
    ElementUI.Message({
      type: 'error',
      message: res.msg
    });
    Router.push({
      path:'/'
    });
    return null;
  }
  if (res.token!=null){
    res.data.token=res.token;
  }
  return res;
}

//取出用户信息的权限
export const permissionHandel=(res)=>{
  let permissions = [];
  if (res!=null){
    res.sysRoles.map(role=>{
      role.sysPermissions.map(permission=>{
        permissions.push(permission);
      })
    })
  }
  return permissions;
}


//判断用户权限中是否包含*(拥有所有权限)
export const permissionAllHandel=(res)=>{
  let result = false;
  res.map(r=>{
    if (r.permissionCode === '*') {
      result =true;
    }
  })
  return result;
}


