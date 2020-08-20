package com.example.api.webapi.client.userServer;

import com.example.api.webapi.client.userServer.hystrix.SysUserFallBack;
import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.utils.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@FeignClient(value = "user-server",url = "http://127.0.0.1:9002/sysUser",fallback = SysUserFallBack.class)
public interface SysUserClient {


    /**
     * 通过name查询单条数据
     *
     * @param name 姓名
     * @return 实例对象
     */
    @GetMapping("/queryUserAndRoleAndPermissionAndUrlByName")
    SysUser queryUserAndRoleAndPermissionAndUrlByName(@RequestParam("name") String name);


    /**
     * 通过实体作为筛选条件分页查询
     * @return 对象列表
     */
    @PostMapping("/queryAllBySysUser")
    PageInfo<SysUser> queryAllBySysUser(@RequestBody SysUser sysUser);


    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PostMapping("update")
    Integer update(@RequestBody SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PostMapping("/insert")
    Integer insert(@RequestBody SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @DeleteMapping("/deleteById")
    Integer deleteById(@RequestParam("userId") Integer userId);

}
