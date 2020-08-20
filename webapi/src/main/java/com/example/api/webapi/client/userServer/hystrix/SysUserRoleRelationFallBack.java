package com.example.api.webapi.client.userServer.hystrix;

import com.example.api.webapi.client.userServer.SysUserRoleRelationClient;
import com.example.api.webapi.entity.userServer.SysUserRoleRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)fallBack
 *
 * @author makejava
 * @since 2020-08-05 14:31:12
 */
@Component
public class SysUserRoleRelationFallBack implements SysUserRoleRelationClient {
    private static final Logger logger = LoggerFactory.getLogger(SysUserRoleRelationClient.class);

    public Integer insertAll(List<SysUserRoleRelation> sysUserRoleRelations){
        logger.error("insertAll:API--异常进入熔断");
        System.out.println("insertAll:API--异常进入熔断");
        return null;
    }

}
