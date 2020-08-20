package com.example.api.webapi.client.userServer.hystrix;

import com.example.api.webapi.client.userServer.SysRoleClient;
import com.example.api.webapi.entity.userServer.SysRole;
import com.example.api.webapi.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 用户角色表(SysRole)fallBack
 *
 * @author makejava
 * @since 2020-08-05 14:31:12
 */
@Component
public class SysRoleFallBack implements SysRoleClient {
    private static final Logger logger = LoggerFactory.getLogger(SysRoleClient.class);


    @Override
    public PageInfo<SysRole> queryAllBySysRole(SysRole  SysRole) {
        logger.error("queryAll:API--异常进入熔断");
        System.out.println("queryAll:API--异常进入熔断");
        return null;
    }

    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    @PostMapping("queryAllByUserId")
    public List<SysRole> queryAllByUserId(Integer uId){
        logger.error("queryAllByUserId:API--异常进入熔断");
        System.out.println("queryAllByUserId:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer insert(SysRole sysRole) {
        logger.error("insert:API--异常进入熔断");
        System.out.println("insert:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer update(SysRole sysRole) {
        logger.error("update:API--异常进入熔断");
        System.out.println("update:API--异常进入熔断");
        return null;
    }

    @Override
    public Integer deleteById(Integer roleId) {
        logger.error("deleteById:API--异常进入熔断");
        System.out.println("deleteById:API--异常进入熔断");
        return null;
    }
}
