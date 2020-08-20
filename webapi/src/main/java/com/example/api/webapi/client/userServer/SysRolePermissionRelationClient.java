package com.example.api.webapi.client.userServer;


import com.example.api.webapi.client.userServer.hystrix.SysRolePermissionRelationFallBack;
import com.example.api.webapi.entity.userServer.SysRolePermissionRelation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@FeignClient(value = "user-server",url = "http://127.0.0.1:9002/sysRolePermissionRelation",fallback = SysRolePermissionRelationFallBack.class)
public interface SysRolePermissionRelationClient {

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    @PostMapping("insertAll")
    public Integer insertAll(@RequestBody List<SysRolePermissionRelation> sysUserRoleRelations);
}
