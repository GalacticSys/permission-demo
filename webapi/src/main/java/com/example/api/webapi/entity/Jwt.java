package com.example.api.webapi.entity;

import com.example.api.webapi.utils.JwtUtil;

public class Jwt {
    //头部
    private String header;
    //消息载体
    private String playLoad;
    //签名
    private String signature;

    public Jwt(String playLoad) {
        this.header = JwtUtil.enCode(JwtUtil.DEFAULT_HEADER);
        this.playLoad = JwtUtil.enCode(playLoad);
        this.signature = JwtUtil.getSignature(playLoad);
    }

    @Override
    public String toString() {
        return header + "." + playLoad + "." + signature;
    }
}
