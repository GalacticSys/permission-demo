package com.example.api.webapi.config.security;

import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.utils.SystemMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    private SystemMessage<SysUser> result;
    @Override//注销功能，默认接口/logout
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        SystemMessage<String> result = new SystemMessage<>();
        result.setCode("200");
        result.setMsg("注销成功");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
