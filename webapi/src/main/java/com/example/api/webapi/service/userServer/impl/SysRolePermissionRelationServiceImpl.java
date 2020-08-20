package com.example.api.webapi.service.userServer.impl;

import com.example.api.webapi.client.userServer.SysRolePermissionRelationClient;
import com.example.api.webapi.entity.userServer.SysRolePermissionRelation;
import com.example.api.webapi.service.userServer.SysRolePermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
@Service("sysRolePermissionRelationService")
public class SysRolePermissionRelationServiceImpl implements SysRolePermissionRelationService {
    @Autowired
    private SysRolePermissionRelationClient sysRolePermissionRelationClient;

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    public Integer insertAll(List<SysRolePermissionRelation> sysUserRoleRelations){
        return sysRolePermissionRelationClient.insertAll(sysUserRoleRelations);
    }
}
