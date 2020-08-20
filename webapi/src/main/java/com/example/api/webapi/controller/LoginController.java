package com.example.api.webapi.controller;

import com.example.api.webapi.utils.SystemMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Api(tags="LoginController")
@Controller
public class LoginController {

    @GetMapping("/toLogin")
    @ApiOperation(value="toLogin方法", notes="index")
    public String toLogin(){
        System.out.println("toLogin");
        return "login";
    }

    @GetMapping("/toError")
    public String toError(){
        System.out.println("toError");
        return "error";
    }
    @PostMapping("/success")
    public String success(){
        SystemMessage<String> result = new SystemMessage<>();
        UserDetails userDetils = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetils.toString());
        return "index";
    }
}
