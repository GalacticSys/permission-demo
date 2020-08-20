package com.hjt.client.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjt.client.dao.SysUserDao;
import com.hjt.client.entity.SysUser;
import com.hjt.client.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;


    /**
     * 通过ID查询单条数据(包括权限)
     *
     * @param name 姓名
     * @return 实例对象
     */
    @Override
    public SysUser queryUserAndRoleAndPermissionAndUrlByName(String name) {
        return this.sysUserDao.queryUserAndRoleAndPermissionAndUrlByName(name);
    }

    /**
     * 通过实体作为筛选条件分页查询
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUser> queryAllBySysUser(SysUser sysUser) {
        PageHelper.startPage(sysUser.getStart(),sysUser.getRows());
        List<SysUser> sysUsers = this.sysUserDao.queryAllBySysUser(sysUser);
        PageInfo<SysUser> sysUserPageInfo = new PageInfo<>(sysUsers);
        System.out.println(sysUserPageInfo.toString());
        return sysUserPageInfo;
    }


    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(SysUser sysUser) {
        if (sysUser.getUserId()!=null){
            return this.sysUserDao.update(sysUser);
        }else {
            return this.sysUserDao.insert(sysUser);
        }
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响的行数
     */
    @Override
    public Integer update(SysUser sysUser) {

        return this.sysUserDao.update(sysUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.sysUserDao.deleteById(id);
    }
}
