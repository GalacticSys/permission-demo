package com.hjt.client.service;


import com.hjt.client.entity.SysRolePermissionRelation;

import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
public interface SysRolePermissionRelationService {

    /**
     * 新增数据
     *
     * @param sysRolePermissionRelations 实例对象集合
     * @return 实例对象
     */
    Integer insertAll(List<SysRolePermissionRelation> sysRolePermissionRelations);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Integer deleteById(Integer id);

    /**
     * 通过roleId删除数据
     *
     * @param roleId 角色id
     * @return 是否成功
     */
    Integer deleteByRoleId(Integer roleId);

}
