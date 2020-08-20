package com.example.api.webapi.utils;

import java.io.Serializable;

public class SystemMessage<T> implements Serializable {
    private static final long serialVersionUID = -2062821971035387344L;
    private String msg;
    private String code;
    private String token;//用作登录返回token
    private T data;

    public SystemMessage() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
