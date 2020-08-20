package com.example.api.webapi.service.userServer;


import com.example.api.webapi.entity.userServer.SysUserRoleRelation;

import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
public interface SysUserRoleRelationService {

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    public Integer insertAll(List<SysUserRoleRelation> sysUserRoleRelations);
}
