package com.example.api.webapi.client.userServer;

import com.example.api.webapi.client.userServer.hystrix.SysPermissionFallBack;
import com.example.api.webapi.entity.userServer.SysPermission;
import com.example.api.webapi.utils.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限表(SysPermission)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:04
 */
@FeignClient(value = "user-server",url="http://127.0.0.1:9002/sysPermission",fallback =SysPermissionFallBack.class)
public interface SysPermissionClient {


    /**
     * 查询多条数据
     *
     * @param sysPermission 主键
     * @return 单条数据
     */
    @PostMapping("queryAllByPermission")
    PageInfo<SysPermission> queryAllByPermission(@RequestBody SysPermission sysPermission);

    /**
     * 通过角色id查询权限
     *
     * @param roleId 角色id
     * @return 对象列表
     */
    @GetMapping("queryByRoleId")
    List<SysPermission> queryByRoleId(@RequestParam("roleId") Integer roleId);


    /**
     * 新增数据
     *
     * @param sysPermission 实体对象
     * @return 单条数据
     */
    @PostMapping("insert")
    Integer insert(@RequestBody SysPermission sysPermission);

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @PostMapping("update")
    Integer update(@RequestBody SysPermission sysPermission);

    /**
     * 通过主键删除数据
     *
     * @param permissionId 主键
     * @return 是否成功
     */
    @DeleteMapping("deleteById")
    Integer deleteById(@RequestParam("permissionId") Integer permissionId);
}
