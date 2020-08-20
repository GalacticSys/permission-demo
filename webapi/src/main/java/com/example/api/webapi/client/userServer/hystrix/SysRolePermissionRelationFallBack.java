package com.example.api.webapi.client.userServer.hystrix;

import com.example.api.webapi.client.userServer.SysRolePermissionRelationClient;
import com.example.api.webapi.entity.userServer.SysRolePermissionRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)fallBack
 *
 * @author makejava
 * @since 2020-08-05 14:31:12
 */
@Component
public class SysRolePermissionRelationFallBack implements SysRolePermissionRelationClient {
    private static final Logger logger = LoggerFactory.getLogger(SysRolePermissionRelationClient.class);


    public Integer insertAll(@RequestBody List<SysRolePermissionRelation> sysUserRoleRelations){
        logger.error("deleteById:API--异常进入熔断");
        System.out.println("deleteById:API--异常进入熔断");
        return null;
    }
}
