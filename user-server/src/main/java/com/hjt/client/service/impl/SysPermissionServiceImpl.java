package com.hjt.client.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjt.client.dao.SysPermissionDao;
import com.hjt.client.entity.SysPermission;
import com.hjt.client.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:11
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;


    /**
     * 查询多条数据
     *
     * @param sysPermission 实体对象
     * @return 对象列表
     */
    @Override
    public PageInfo<SysPermission> queryAllByPermission(SysPermission sysPermission) {
        PageHelper.startPage(sysPermission.getStart(),sysPermission.getRows());
        List<SysPermission> sysPermissions = this.sysPermissionDao.queryAllByPermission(sysPermission);
        PageInfo<SysPermission> sysUserPageInfo = new PageInfo<>(sysPermissions);
        return sysUserPageInfo;
    }

    /**
     * 通过角色id查询权限
     *
     * @param roleId 角色id
     * @return 对象列表
     */
    public List<SysPermission> queryByRoleId( Integer roleId){
        return this.sysPermissionDao.queryByRoleId(roleId);
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(SysPermission sysPermission) {
        if (sysPermission.getPermissionId()!=null){
            return this.sysPermissionDao.update(sysPermission);
        }else {
            return this.sysPermissionDao.insert(sysPermission);
        }
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(SysPermission sysPermission) {
        return this.sysPermissionDao.update(sysPermission);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.sysPermissionDao.deleteById(id);
    }
}
