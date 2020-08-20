package com.hjt.client.controller;

import com.hjt.client.entity.SysRolePermissionRelation;
import com.hjt.client.service.SysRolePermissionRelationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@RestController
@RequestMapping("sysRolePermissionRelation")
public class SysRolePermissionRelationController {
    /**
     * 服务对象
     */
    @Resource
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    @PostMapping("insertAll")
    public Integer insertAll(@RequestBody List<SysRolePermissionRelation> sysUserRoleRelations) {
        return this.sysRolePermissionRelationService.insertAll(sysUserRoleRelations);
    }

}
