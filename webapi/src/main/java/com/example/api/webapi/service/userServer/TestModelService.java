package com.example.api.webapi.service.userServer;

import com.example.api.webapi.client.userServer.TestModelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestModelService {
    @Autowired
    TestModelClient testModelClient;
    public String test(){
        return testModelClient.test();
    }


}
