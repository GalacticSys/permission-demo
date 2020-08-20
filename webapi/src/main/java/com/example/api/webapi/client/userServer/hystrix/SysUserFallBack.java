package com.example.api.webapi.client.userServer.hystrix;

import com.example.api.webapi.client.userServer.SysUserClient;
import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用户表(SysUser)fallBack
 *
 * @author makejava
 * @since 2020-08-05 14:31:12
 */
@Component
public class SysUserFallBack implements SysUserClient {
    private static final Logger logger = LoggerFactory.getLogger(SysUserClient.class);

    @Override
    public SysUser queryUserAndRoleAndPermissionAndUrlByName(String name) {
        logger.error("queryUserAndRoleAndPermissionAndUrlByName:API--异常进入熔断");
        System.out.println("queryUserAndRoleAndPermissionAndUrlByName:API--异常进入熔断");
        return null;
    }



    @Override
    public PageInfo<SysUser> queryAllBySysUser(SysUser sysUser) {
        logger.error("queryUserAndRoleAndPermissionAndUrlAll:API--异常进入熔断");
        System.out.println("queryUserAndRoleAndPermissionAndUrlAll:API--异常进入熔断");
        return null;
    }
    @Override
    public Integer insert( SysUser sysUser) {
        logger.error("insert:API--异常进入熔断");
        System.out.println("insert:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer update( SysUser  SysUser) {
        logger.error("update:API--异常进入熔断");
        System.out.println("update:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer deleteById(Integer id) {
        logger.error("deleteById:API--异常进入熔断");
        System.out.println("deleteById:API--异常进入熔断");
        return null;
    }
}
