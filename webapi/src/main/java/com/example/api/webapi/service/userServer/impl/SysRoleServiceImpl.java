package com.example.api.webapi.service.userServer.impl;

import com.example.api.webapi.client.userServer.SysRoleClient;
import com.example.api.webapi.entity.userServer.SysRole;
import com.example.api.webapi.service.userServer.SysRoleService;
import com.example.api.webapi.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleClient sysRoleClient;


    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */
    @Override
    public PageInfo<SysRole> queryAllBySysRole(SysRole sysRole){
        return this.sysRoleClient.queryAllBySysRole(sysRole);
    }


    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    public List<SysRole> queryAllByUserId(Integer uId){
        return this.sysRoleClient.queryAllByUserId(uId);
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(SysRole sysRole) {
        return this.sysRoleClient.insert(sysRole);
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(SysRole sysRole) {
        return this.sysRoleClient.update(sysRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.sysRoleClient.deleteById(id);
    }
}
