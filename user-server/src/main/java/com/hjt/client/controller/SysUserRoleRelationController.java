package com.hjt.client.controller;

import com.hjt.client.entity.SysUserRoleRelation;
import com.hjt.client.service.SysUserRoleRelationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@RestController
@RequestMapping("sysUserRoleRelation")
public class SysUserRoleRelationController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserRoleRelationService sysUserRoleRelationService;

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    @PostMapping("insertAll")
    public Integer insertAll(@RequestBody List<SysUserRoleRelation> sysUserRoleRelations) {
        return this.sysUserRoleRelationService.insertAll(sysUserRoleRelations);
    }

}
