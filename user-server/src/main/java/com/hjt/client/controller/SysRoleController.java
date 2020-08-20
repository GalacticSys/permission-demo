package com.hjt.client.controller;

import com.github.pagehelper.PageInfo;
import com.hjt.client.entity.SysRole;
import com.hjt.client.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色表(SysRole)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;



    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */
    @PostMapping("queryAllBySysRole")
    public PageInfo<SysRole> queryAllBySysRole(@RequestBody SysRole sysRole) {
        return this.sysRoleService.queryAllBySysRole(sysRole);
    }


    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    @GetMapping("queryAllByUserId")
    public List<SysRole> queryAllByUserId(Integer uId){
        return this.sysRoleService.queryAllByUserId(uId);
    }

    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */
    @PostMapping("insert")
    public Integer insert(@RequestBody SysRole sysRole) {
        return this.sysRoleService.insert(sysRole);
    }


    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @PostMapping("update")
    Integer update(@RequestBody SysRole sysRole){
        return this.sysRoleService.update(sysRole);
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @DeleteMapping("deleteById")
    Integer deleteById(Integer roleId){
        return this.sysRoleService.deleteById(roleId);
    }
}
