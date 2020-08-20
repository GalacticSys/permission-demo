package com.hjt.client.controller;

import com.github.pagehelper.PageInfo;
import com.hjt.client.entity.SysPermission;
import com.hjt.client.service.SysPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(SysPermission)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:04
 */
@RestController
@RequestMapping("sysPermission")
public class SysPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private SysPermissionService sysPermissionService;


    /**
     * 查询多条数据
     *
     * @param sysPermission 主键
     * @return 单条数据
     */
    @PostMapping("queryAllByPermission")
    public PageInfo<SysPermission> queryAllByPermission(@RequestBody SysPermission sysPermission) {
        System.out.println("queryAllByPermission");
        return this.sysPermissionService.queryAllByPermission(sysPermission);
    }

    /**
     * 通过角色id查询权限
     *
     * @param roleId 角色id
     * @return 对象列表
     */
    @GetMapping("queryByRoleId")
    public List<SysPermission> queryByRoleId(Integer roleId){
        return this.sysPermissionService.queryByRoleId(roleId);
    }


    /**
     * 新增数据
     *
     * @param sysPermission 实体对象
     * @return 单条数据
     */
    @PostMapping("insert")
    public Integer insert(@RequestBody SysPermission sysPermission) {
        System.out.println("insert");
        return this.sysPermissionService.insert(sysPermission);
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @PostMapping("update")
    Integer update(SysPermission sysPermission){
        return this.sysPermissionService.update(sysPermission);
    }

    /**
     * 通过主键删除数据
     *
     * @param permissionId 主键
     * @return 是否成功
     */
    @DeleteMapping("deleteById")
    Integer deleteById(Integer permissionId){
        return this.sysPermissionService.deleteById(permissionId);
    }

}
