package com.example.api.webapi.service.userServer.impl;

import com.example.api.webapi.client.userServer.SysUserClient;
import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.service.userServer.SysUserService;
import com.example.api.webapi.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserClient sysUserClient;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 通过ID查询单条数据(包括权限)
     *
     * @param name 姓名
     * @return 实例对象
     */
    @Override
    public SysUser queryUserAndRoleAndPermissionAndUrlByName(String name) {
        return this.sysUserClient.queryUserAndRoleAndPermissionAndUrlByName(name);
    }

    /**
     * 查询所有
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUser> queryAllBySysUser(SysUser sysUser) {
        return this.sysUserClient.queryAllBySysUser(sysUser);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(SysUser sysUser) {
        return this.sysUserClient.insert(sysUser);
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(SysUser sysUser) {
        return this.sysUserClient.update(sysUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.sysUserClient.deleteById(id);
    }
}
