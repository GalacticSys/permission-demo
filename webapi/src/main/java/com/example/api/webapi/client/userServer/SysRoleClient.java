package com.example.api.webapi.client.userServer;

import com.example.api.webapi.client.userServer.hystrix.SysRoleFallBack;
import com.example.api.webapi.entity.userServer.SysRole;
import com.example.api.webapi.utils.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户角色表(SysRole)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@FeignClient(value = "user-server",url = "http://127.0.0.1:9002/sysRole",fallback = SysRoleFallBack.class)
public interface SysRoleClient {



    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */
    @PostMapping("queryAllBySysRole")
    public PageInfo<SysRole> queryAllBySysRole(@RequestBody SysRole sysRole);


    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    @GetMapping("queryAllByUserId")
    public List<SysRole> queryAllByUserId(@RequestParam("uId") Integer uId);

    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */
    @PostMapping("insert")
    public Integer insert(@RequestBody SysRole sysRole);


    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @PostMapping("update")
    Integer update(@RequestBody SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @DeleteMapping("deleteById")
    Integer deleteById(@RequestParam("roleId") Integer roleId);
}
