package com.example.api.webapi.controller.userServer;

import com.example.api.webapi.service.userServer.TestModelService;
import com.example.api.webapi.utils.SystemMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="TestModelController")
@RestController
public class TestModelController {
    @Autowired
    TestModelService testModelService;

    @GetMapping("/test")
    @ApiOperation(value="test方法", notes="index")
    public SystemMessage<String> test(){
        SystemMessage<String> result = new SystemMessage<>();
        System.out.println("调用client2");
        try {
            String test = testModelService.test();
            result.setData(test);
            result.setMsg("成功");
            result.setCode("200");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
        }
        return result;
    }


}
