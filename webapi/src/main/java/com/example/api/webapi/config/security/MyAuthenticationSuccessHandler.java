package com.example.api.webapi.config.security;

import com.alibaba.fastjson.JSONObject;
import com.example.api.webapi.entity.Jwt;
import com.example.api.webapi.entity.MyUserDetails;
import com.example.api.webapi.utils.JwtUtil;
import com.example.api.webapi.utils.SystemMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//security认证成功



public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        SystemMessage<MyUserDetails> result = new SystemMessage<>();
        System.out.println("认证成功后。。。");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        boolean loginBoolean = true;
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        myUserDetails.getSysUser().setPassword("");
        long now = System.currentTimeMillis();
        JSONObject payLoad = new JSONObject();
        payLoad.put("iss","sys");//签发人
        payLoad.put("aut",myUserDetails.getSysUser().getUserName());//签发人
        payLoad.put("exp",String.valueOf(now+ JwtUtil.EXPIRE_TIME));//过期时间
        payLoad.put("nbf",now);//生效时间
        payLoad.put("iat",now);//签发时间
        payLoad.put("jti",myUserDetails.getSysUser().getUserId());//编号
        payLoad.put("sub","JWT-TEST");//主题
        payLoad.put("user",myUserDetails);//用户对象
        String token = new Jwt(payLoad.toJSONString()).toString();
        try {
            response.setHeader(JwtUtil.HEADER_TOKEN_NAME,token);
        }catch (Exception e){
            loginBoolean = false;
        }
        if (loginBoolean){
            result.setCode("200");
            result.setMsg("登录成功");
            result.setData(myUserDetails);
            result.setToken(token);
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        }else {
            result.setCode("500");
            result.setMsg("登录失败");
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        }
    }
}
