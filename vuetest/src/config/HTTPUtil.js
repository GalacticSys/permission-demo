let HTTPUtil = {};
import ElementUI from 'element-ui';


/**
 * 基于 fetch 封装的 GET请求
 * @param url
 * @param params {}
 * @param headers
 * @returns {Promise}
 */
HTTPUtil.get = function(url, params) {
  if (params) {
    let paramsArray = [];
    //encodeURIComponent
    Object.keys(params).forEach(key => {
        paramsArray.push(key + '=' + params[key]);
      }
    )
    if (url.search(/\?/) === -1) {
      url += '?' + paramsArray.join('&')
    } else {
      url += '&' + paramsArray.join('&')
    }
  }
  return new Promise(function (resolve, reject) {
    let headers = {
      'Accept' : 'application/json',
      'Content-Type' : 'application/json',
      'Authorization' : localStorage.getItem('Authorization')
    };
    fetch(url, {
      method: 'GET',
      headers: headers,
    })
      .then((response) => {
        if (response.ok) {
            return response.json();
        } else {
          reject({status:response.status})
        }
      })
      .then((response) => {
        resolve(response);
      })
      .catch((err)=> {
        ElementUI.Message({
          type: 'error',
          message: '请求异常'
        })
        reject({status:-1});
      })
  })
}


/**
 * 基于 fetch 封装的 POST请求  FormData 表单数据
 * @param url
 * @param formData
 * @param headers
 * @returns {Promise}
 */
HTTPUtil.post = function(url, data) {
  return new Promise(function (resolve, reject) {
    let headlers = {
      'Accept' : 'application/json',
      'Content-Type' : 'application/json',
      'Authorization' : localStorage.getItem('Authorization')
    };
    if (url==='/api/authentication/form'){
      headlers={
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      }
    }
    fetch(url, {
      method: 'POST',
      headers: headlers,
      body:JSON.stringify(data)
    })
      .then((response) => {
        if (response.ok) {
            return response.json();
        } else {
          reject({status:response.status})
        }
      })
      .then((res) => {
        resolve(res);
      })
      .catch((err)=> {
        ElementUI.Message({
          type: 'error',
          message: '请求异常'
        })
        reject({status:-1});
      })
  })

}




/**
 * 基于 fetch 封装的 Delete请求
 * @param url
 * @param params {}
 * @param headers
 * @returns {Promise}
 */
HTTPUtil.delete = function(url, params) {
  if (params) {
    let paramsArray = [];
    //encodeURIComponent
    Object.keys(params).forEach(key => {
        paramsArray.push(key + '=' + params[key]);
      }
    )
    if (url.search(/\?/) === -1) {
      url += '?' + paramsArray.join('&')
    } else {
      url += '&' + paramsArray.join('&')
    }
  }
  return new Promise(function (resolve, reject) {
    let headlers = {
      'Accept' : 'application/json',
      'Content-Type' : 'application/json',
      'Authorization' : localStorage.getItem('Authorization')
    };
    fetch(url, {
      method: 'DELETE',
      headers: headlers,
    })
      .then((response) => {
        if (response.ok) {
            return response.json();
        } else {
          reject({status:response.status})
        }
      })
      .then((response) => {
        resolve(response);
      })
      .catch((err)=> {
        ElementUI.Message({
          type: 'error',
          message: '请求异常'
        })
        // reject({status:-1});
      })
  })
}


export default HTTPUtil;
