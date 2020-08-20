package com.hjt.client.service.impl;

import com.hjt.client.dao.SysUserRoleRelationDao;
import com.hjt.client.entity.SysUserRoleRelation;
import com.hjt.client.service.SysUserRoleRelationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 01:39:13
 */
@Service("sysUserRoleRelationService")
public class SysUserRoleRelationServiceImpl implements SysUserRoleRelationService {
    @Resource
    private SysUserRoleRelationDao sysUserRoleRelationDao;

    /**
     * 新增数据
     *
     * @param sysUserRoleRelations 实例对象集合
     * @return 实例对象
     */
    @Override
    public Integer insertAll(List<SysUserRoleRelation> sysUserRoleRelations) {
        int result = 0;
        if (!CollectionUtils.isEmpty(sysUserRoleRelations)){
            this.sysUserRoleRelationDao.deleteByUserId(sysUserRoleRelations.get(0).getUserId());
            for (SysUserRoleRelation sysUserRoleRelation : sysUserRoleRelations) {
                result=result+this.sysUserRoleRelationDao.insert(sysUserRoleRelation);
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
        return this.sysUserRoleRelationDao.deleteById(id);
    }

    /**
     * 根据用户Id删除数据
     * @param userId
     * @return
     */
    public Integer deleteByUserId( Integer userId){
        return this.sysUserRoleRelationDao.deleteByUserId(userId);
    }
}
