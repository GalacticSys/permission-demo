package com.example.api.webapi.service.userServer.impl;

import com.example.api.webapi.client.userServer.SysUserRoleRelationClient;
import com.example.api.webapi.entity.userServer.SysUserRoleRelation;
import com.example.api.webapi.service.userServer.SysUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:13
 */
@Service("sysUserRoleRelationService")
public class SysUserRoleRelationServiceImpl implements SysUserRoleRelationService {
    @Autowired
    private SysUserRoleRelationClient sysUserRoleRelationClient;

    @Override
    public Integer insertAll(List<SysUserRoleRelation> sysUserRoleRelations) {
        return this.sysUserRoleRelationClient.insertAll(sysUserRoleRelations);
    }
}
