package com.hjt.client.dao;

import com.hjt.client.entity.SysUserRoleRelation;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-05 01:15:40
 */
public interface SysUserRoleRelationDao {

    /**
     * 新增数据
     *
     * @param sysUserRoleRelation 实例对象
     * @return 影响行数
     */
    Integer insert(@Param("sysUserRoleRelation") SysUserRoleRelation sysUserRoleRelation);


    /**
     * 通过主键删除数据
     *
     * @param userRoleId 主键
     * @return 影响行数
     */
    Integer deleteById(@Param("userRoleId")Integer userRoleId);

    /**
     * 根据用户Id删除数据
     * @param userId
     * @return
     */
    Integer deleteByUserId(@Param("userId") Integer userId);

}
