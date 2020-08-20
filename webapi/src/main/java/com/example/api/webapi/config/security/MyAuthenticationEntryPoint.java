package com.example.api.webapi.config.security;

import com.example.api.webapi.utils.SystemMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        System.out.println("未登录验证");
        response.setContentType("application/json;charset=utf-8");
        SystemMessage<String> result = new SystemMessage<>();
        result.setCode("401");
        result.setMsg("未登录");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
