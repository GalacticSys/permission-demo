package com.example.api.webapi.controller.userServer;

import com.example.api.webapi.entity.userServer.SysPermission;
import com.example.api.webapi.service.userServer.SysPermissionService;
import com.example.api.webapi.utils.PageInfo;
import com.example.api.webapi.utils.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 查询多条数据
     *
     * @param sysPermission 主键
     * @return 单条数据
     */
    @PostMapping("queryAllByPermission")
    @PreAuthorize("hasPermission('/queryAllByPermission','query_permission')")
    public SystemMessage<PageInfo<SysPermission>> queryAllByPermission(@RequestBody SysPermission sysPermission) {
        SystemMessage<PageInfo<SysPermission>> result = new SystemMessage<>();
        try {
            PageInfo<SysPermission> sysPermissions = this.sysPermissionService.queryAllByPermission(sysPermission);
            result.setCode("200");
            result.setData(sysPermissions);
            result.setMsg("成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }


    /**
     * 通过角色id查询权限
     *
     * @param roleId 角色id
     * @return 对象列表
     */
    @GetMapping("queryByRoleId")
    public SystemMessage< List<SysPermission>> queryByRoleId(Integer roleId){
        SystemMessage< List<SysPermission>> result = new SystemMessage<>();
        try {
            List<SysPermission> sysPermissions = sysPermissionService.queryByRoleId(roleId);
            result.setCode("200");
            result.setData(sysPermissions);
            result.setMsg("查询成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }


    /**
     * 新增数据
     *
     * @param sysPermission 实体对象
     * @return 单条数据
     */
    @PostMapping("/insert")
    @PreAuthorize("hasPermission('/insert','insert_permission')")
    public SystemMessage<Integer> insert(@RequestBody SysPermission sysPermission) {
        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            Integer insert = this.sysPermissionService.insert(sysPermission);
            result.setCode("200");
            result.setData(insert);
            result.setMsg("成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 新增数据
     *
     * @param permissionId 实体对象
     * @return 单条数据
     */
    @DeleteMapping("/deleteById")
    @PreAuthorize("hasPermission('/deleteById','delete_permission')")
    public SystemMessage<Integer> deleteById(Integer permissionId) {
        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            Integer insert = this.sysPermissionService.deleteById(permissionId);
            result.setCode("200");
            result.setData(insert);
            result.setMsg("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }


}
