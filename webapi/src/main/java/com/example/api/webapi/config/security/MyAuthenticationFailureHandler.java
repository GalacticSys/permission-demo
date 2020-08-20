package com.example.api.webapi.config.security;

import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.utils.SystemMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private SystemMessage<SysUser> result;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        result = new SystemMessage<>();//返回值
        result.setCode("400");
        if (e instanceof LockedException) {
            result.setMsg("账户被锁定，请联系管理员！");
        } else if (e instanceof CredentialsExpiredException) {
            result.setMsg("密码过期，请联系管理员！");
        } else if (e instanceof AccountExpiredException) {
            result.setMsg("账户过期，请联系管理员！");
        } else if (e instanceof DisabledException) {
            result.setMsg("账户被禁用，请联系管理员！");
        } else if (e instanceof BadCredentialsException) {
            result.setMsg("用户名或密码输入错误，请重新输入！");
        }
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
