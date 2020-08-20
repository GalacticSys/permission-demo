package com.hjt.client.dao;

import com.hjt.client.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-05 01:15:39
 */
public interface SysUserDao {





    /**
     * 通过name查询单条数据
     *
     * @param name 主键
     * @return 实例对象
     */
    SysUser queryUserAndRoleAndPermissionAndUrlByName(@Param("name") String name);

    /**
     * 通过实体作为筛选条件分页查询
     * @return 对象列表
     */
    List<SysUser> queryAllBySysUser(@Param("sysUser") SysUser sysUser);




    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(@Param("sysUser") SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响的行数
     */
    int update(@Param("sysUser")SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(@Param("userId")Integer userId);


}
