package com.example.api.webapi.client.userServer;

import com.example.api.webapi.client.userServer.hystrix.SysUserRoleRelationFallBack;
import com.example.api.webapi.entity.userServer.SysUserRoleRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@FeignClient(value = "user-server",url = "http://127.0.0.1:9002/sysUserRoleRelation",fallback = SysUserRoleRelationFallBack.class)
public interface SysUserRoleRelationClient {

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    @PostMapping("insertAll")
    public Integer insertAll(@RequestBody List<SysUserRoleRelation> sysUserRoleRelations);
}
