package com.hjt.client.dao;

import com.hjt.client.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限表(SysPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-05 01:15:33
 */
public interface SysPermissionDao {


    /**
     * 通过实体作为筛选分页条件查询
     *
     * @param sysPermission 实例对象
     * @return 对象列表
     */
    List<SysPermission> queryAllByPermission(@Param("sysPermission")SysPermission sysPermission);


    /**
     * 通过角色id查询权限
     *
     * @param roleId 角色id
     * @return 对象列表
     */
    List<SysPermission> queryByRoleId(@Param("roleId") Integer roleId);

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    Integer insert(@Param("sysPermission") SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 影响行数
     */
    Integer update(@Param("sysPermission")SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param permissionId 主键
     * @return 影响行数
     */
    Integer deleteById(@Param("permissionId")Integer permissionId);

}
