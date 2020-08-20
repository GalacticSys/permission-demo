package com.example.api.webapi.service.userServer;


import com.example.api.webapi.entity.userServer.SysRolePermissionRelation;

import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
public interface SysRolePermissionRelationService {

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    public Integer insertAll(List<SysRolePermissionRelation> sysUserRoleRelations);
}
