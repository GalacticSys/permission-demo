package com.example.api.webapi.service.userServer;


import com.example.api.webapi.entity.userServer.SysPermission;
import com.example.api.webapi.utils.PageInfo;

import java.util.List;

/**
 * 权限表(SysPermission)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 01:39:10
 */
public interface SysPermissionService {


    /**
     * 查询多条数据
     *
     * @param sysPermission 查询起始位置
     * @return 对象列表
     */
    PageInfo<SysPermission> queryAllByPermission(SysPermission sysPermission);


    /**
     * 通过角色id查询权限
     *
     * @param roleId 角色id
     * @return 对象列表
     */
    List<SysPermission> queryByRoleId(Integer roleId);
    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    Integer insert(SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param permissionId 主键
     * @return 是否成功
     */
    Integer deleteById(Integer permissionId);

}
