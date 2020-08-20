package com.example.api.webapi.client.userServer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-server",url = "http://127.0.0.1:9002/test")
public interface TestModelClient {
    @GetMapping("/test")
    public String test();


}
