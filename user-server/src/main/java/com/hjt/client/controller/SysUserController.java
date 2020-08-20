package com.hjt.client.controller;

import com.github.pagehelper.PageInfo;
import com.hjt.client.entity.SysUser;
import com.hjt.client.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;




    /**
     * 通过name查询单条数据
     *
     * @param name 姓名
     * @return 实例对象
     */
    @GetMapping("/queryUserAndRoleAndPermissionAndUrlByName")
    SysUser queryUserAndRoleAndPermissionAndUrlByName(@RequestParam("name") String name){
        System.out.println("查询");
        SysUser sysUser = this.sysUserService.queryUserAndRoleAndPermissionAndUrlByName(name);
        return sysUser;
    }

    /**
     * 通过实体作为筛选条件分页查询
     * @return 对象列表
     */
    @PostMapping("/queryAllBySysUser")
    PageInfo<SysUser> queryAllBySysUser(@RequestBody SysUser sysUser){
        System.out.println("查询");
        PageInfo<SysUser> sysUserPageInfo = this.sysUserService.queryAllBySysUser(sysUser);
        return sysUserPageInfo;
    }


    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PostMapping("update")
    Integer update(@RequestBody SysUser sysUser){
        return this.sysUserService.update(sysUser);
    }


    @PostMapping("/insert")
    Integer insert(@RequestBody SysUser sysUser){
        System.out.println("新增");
        return this.sysUserService.insert(sysUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @DeleteMapping("/deleteById")
    Integer deleteById( Integer userId){
        System.out.println("新增");
        return this.sysUserService.deleteById(userId);
    }

}
