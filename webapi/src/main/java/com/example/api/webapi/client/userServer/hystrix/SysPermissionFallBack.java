package com.example.api.webapi.client.userServer.hystrix;

import com.example.api.webapi.client.userServer.SysPermissionClient;
import com.example.api.webapi.entity.userServer.SysPermission;
import com.example.api.webapi.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 权限表(SysPermission)fallBack
 *
 * @author makejava
 * @since 2020-08-05 14:31:11
 */
@Component
public class SysPermissionFallBack implements SysPermissionClient {
    private static final Logger logger = LoggerFactory.getLogger(SysPermissionClient.class);


    public PageInfo<SysPermission> queryAllByPermission(SysPermission sysPermission){
        logger.error("queryAll:API--异常进入熔断");
        System.out.println("queryAll:API--异常进入熔断");
        return null;
    }

    public List<SysPermission> queryByRoleId(@RequestParam("roleId") Integer roleId){
        logger.error("queryByRoleId:API--异常进入熔断");
        System.out.println("queryByRoleId:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer insert(SysPermission sysPermission) {
        logger.error("insert:API--异常进入熔断");
        System.out.println("insert:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer update(SysPermission sysPermission) {
        logger.error("update:API--异常进入熔断");
        System.out.println("update:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer deleteById(Integer permissionId) {
        logger.error("deleteById:API--异常进入熔断");
        System.out.println("deleteById:API--异常进入熔断");
        return null;
    }
}
