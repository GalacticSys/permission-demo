package com.hjt.client.dao;

import com.hjt.client.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色表(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-05 01:15:39
 */
public interface SysRoleDao {




    /**
     * 通过实体作为筛选分页条件查询
     *
     * @param sysRole 实例对象
     * @return 对象列表
     */
    List<SysRole> queryAllBySysRole(@Param("sysRole") SysRole sysRole);


    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    List<SysRole> queryAllByUserId(@Param("uId") Integer uId);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int insert(@Param("sysRole")SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int update(@Param("sysRole")SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(@Param("roleId") Integer roleId);

}
