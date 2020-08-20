package com.example.api.webapi.service.userServer.impl;

import com.example.api.webapi.client.userServer.SysPermissionClient;
import com.example.api.webapi.entity.userServer.SysPermission;
import com.example.api.webapi.service.userServer.SysPermissionService;
import com.example.api.webapi.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 权限表(SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:11
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionClient sysPermissionClient;


    /**
     * 查询多条数据
     *
     * @param sysPermission 主键
     * @return 单条数据
     */
    public PageInfo<SysPermission> queryAllByPermission(SysPermission sysPermission){
        return this.sysPermissionClient.queryAllByPermission(sysPermission);
    }


    /**
     * 通过角色id查询权限
     *
     * @param roleId 角色id
     * @return 对象列表
     */
    public List<SysPermission> queryByRoleId(Integer roleId){
        return sysPermissionClient.queryByRoleId(roleId);
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实体对象
     * @return 单条数据
     */
    @GetMapping("insert")
    public Integer insert(SysPermission sysPermission){
        return this.sysPermissionClient.insert(sysPermission);
    }

    @Override
    public Integer deleteById(Integer permissionId) {
        return this.sysPermissionClient.deleteById(permissionId);
    }
}
