package com.example.api.webapi.controller.userServer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    @PreAuthorize("hasRole('admin')")
    public String test(){
        System.out.println("client1");
        return "success";
    }
}
