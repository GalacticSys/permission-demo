package com.hjt.client.service;


import com.hjt.client.entity.SysUserRoleRelation;

import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
public interface SysUserRoleRelationService {

    /**
     * 新增数据
     *
     * @param sysUserRoleRelations 实例对象集合
     * @return 影响行数
     */
    Integer insertAll( List<SysUserRoleRelation> sysUserRoleRelations);


    /**
     * 通过主键删除数据
     *
     * @param userRoleId 主键
     * @return 影响行数
     */
    Integer deleteById(Integer userRoleId);

    /**
     * 根据用户Id删除数据
     * @param userId
     * @return
     */
    Integer deleteByUserId( Integer userId);

}
