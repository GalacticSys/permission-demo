package com.example.api.webapi.config.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.api.webapi.entity.MyUserDetails;
import com.example.api.webapi.utils.JwtUtil;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//token验证过滤器
//我们把security的session改为无状态后，虽然不再传递session，
// 但是security的过滤器并没有失效，因此造成的效果就是登录成功后，
// 访问接口显示未登录。现在我们使用token就要在登录前加一个验证token的过滤器，
// 验证通过后直接把信息放到SecurityContextHolder中。这样每次登录靠验证token来判断是否登录，不再靠session。
@Component
public class MyGenericFilterBean extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("token验证过滤器");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader(JwtUtil.HEADER_TOKEN_NAME);
        if (token!=null && token.trim().length()>0 &&!token.equals("null")){
            token=token.substring(7);
            String tockenBody = null;

            try {
                tockenBody = JwtUtil.testJwt(token);
            }catch (Exception e){
                System.out.println("error MyGenericFilterBean doFilter========="+e.getMessage());
            }
            if (tockenBody != null && tockenBody.trim().length() > 0) {
                Gson gson = new Gson();
                Map<String, String> map = new HashMap<>();
                map = gson.fromJson(tockenBody, map.getClass());//关键
                System.out.println("=============================");
                System.out.println(map.get("exp"));
                //判断token是否过期
                //如果过期
                if (Long.parseLong(map.get("exp"))<System.currentTimeMillis()){
                    HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
                    httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    httpServletResponse.getWriter().write("{\"code\":\"405\",\"msg\":\"tocken异常\"}");
                    return;
                }
                JSONObject user = JSON.parseObject(tockenBody).getJSONObject("user");
                MyUserDetails myUserDetails = JSON.toJavaObject(user,MyUserDetails.class);
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(myUserDetails,null,myUserDetails.getAuthorities()));
            }else {
                HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                httpServletResponse.getWriter().write("{\"code\":\"405\",\"msg\":\"登录失效了\"}");
                return;
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
