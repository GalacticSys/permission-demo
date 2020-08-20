package com.example.api.webapi.service.userServer;


import com.example.api.webapi.entity.userServer.SysRole;
import com.example.api.webapi.utils.PageInfo;

import java.util.List;

/**
 * 用户角色表(SysRole)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
public interface SysRoleService {



    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */
    public PageInfo<SysRole> queryAllBySysRole(SysRole sysRole);


    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    public List<SysRole> queryAllByUserId(Integer uId);

    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */

    public Integer insert(SysRole sysRole);


    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */

    Integer update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */

    Integer deleteById(Integer roleId);
}
