package com.example.api.webapi.config.security;

import com.example.api.webapi.utils.SystemMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAccessDeineHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        SystemMessage<String> result = new SystemMessage<>();
        result.setCode("403");
        result.setMsg("无权限");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }

}
