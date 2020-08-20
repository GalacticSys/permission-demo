package com.hjt.client.dao;

import com.hjt.client.entity.SysRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-05 01:15:39
 */
public interface SysRolePermissionRelationDao {





    /**
     * 新增数据
     *
     * @param sysRolePermissionRelation 实例对象
     * @return 影响行数
     */
    Integer insert(@Param("sysRolePermissionRelation") SysRolePermissionRelation sysRolePermissionRelation);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Integer deleteById(@Param("id") Integer id);

    /**
     * 通过permissionId删除数据
     *
     * @param roleId 角色id
     * @return 是否成功
     */
    Integer deleteByRoleId(@Param("roleId") Integer roleId);


}
