package com.hjt.client.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjt.client.dao.SysRoleDao;
import com.hjt.client.entity.SysRole;
import com.hjt.client.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色表(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleDao sysRoleDao;

    /**
     * 查询所有
     * @return 对象列表
     */
    @Override
    public PageInfo<SysRole> queryAllBySysRole(SysRole sysRole) {
        if (sysRole.getStart()==0&&sysRole.getRows()==0){

        }else {
            PageHelper.startPage(sysRole.getStart(),sysRole.getRows());
        }
        List<SysRole> sysUsers = this.sysRoleDao.queryAllBySysRole(sysRole);
        PageInfo<SysRole> sysUserPageInfo = new PageInfo<>(sysUsers);
        System.out.println(sysUserPageInfo.toString());
        return sysUserPageInfo;
    }


    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    public List<SysRole> queryAllByUserId(Integer uId){
        return this.sysRoleDao.queryAllByUserId(uId);
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(SysRole sysRole) {
        if (sysRole.getRoleId()!=null){
            return this.sysRoleDao.update(sysRole);
        }else {
            sysRole.setRoleCode("ROLE_"+sysRole.getRoleCode());
            return this.sysRoleDao.insert(sysRole);
        }
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(SysRole sysRole) {

        return  this.sysRoleDao.update(sysRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.sysRoleDao.deleteById(id);
    }
}
