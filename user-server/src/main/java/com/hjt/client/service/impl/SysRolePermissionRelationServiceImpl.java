package com.hjt.client.service.impl;

import com.hjt.client.dao.SysRolePermissionRelationDao;
import com.hjt.client.entity.SysRolePermissionRelation;
import com.hjt.client.service.SysRolePermissionRelationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:12
 */
@Service("sysRolePermissionRelationService")
public class SysRolePermissionRelationServiceImpl implements SysRolePermissionRelationService {
    @Resource
    private SysRolePermissionRelationDao sysRolePermissionRelationDao;




    /**
     * 新增数据
     *
     * @param sysRolePermissionRelations 实例对象集合
     * @return 实例对象
     */
    @Override
    public Integer insertAll(List<SysRolePermissionRelation> sysRolePermissionRelations) {
        int result = 0;
        if (!CollectionUtils.isEmpty(sysRolePermissionRelations)){
            this.sysRolePermissionRelationDao.deleteByRoleId(sysRolePermissionRelations.get(0).getRoleId());
            for (SysRolePermissionRelation sysRolePermissionRelation : sysRolePermissionRelations) {
                result = result+this.sysRolePermissionRelationDao.insert(sysRolePermissionRelation);
            }
        }

        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        return this.sysRolePermissionRelationDao.deleteById(id);
    }

    /**
     * 通过roleId删除数据
     *
     * @param roleId 角色id
     * @return 是否成功
     */
    @Override
    public Integer deleteByRoleId(Integer roleId) {
        return this.sysRolePermissionRelationDao.deleteByRoleId(roleId);
    }
}
