package com.example.api.webapi.service.userServer;


import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.utils.PageInfo;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
public interface SysUserService {

    /**
     * 通过name查询单条数据(包括权限)
     *
     * @param name 姓名
     * @return 实例对象
     */
    SysUser queryUserAndRoleAndPermissionAndUrlByName(String name);

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    PageInfo<SysUser> queryAllBySysUser(SysUser sysUser);
    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    Integer insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    Integer update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Integer deleteById(Integer id);

}
