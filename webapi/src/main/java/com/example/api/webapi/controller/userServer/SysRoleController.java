package com.example.api.webapi.controller.userServer;

import com.example.api.webapi.entity.userServer.SysRole;
import com.example.api.webapi.service.userServer.SysRoleService;
import com.example.api.webapi.utils.PageInfo;
import com.example.api.webapi.utils.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private SysRoleService sysRoleService;


    /**
     * 根据查询条件分页查询多条数据
     *
     * @param sysRole 查询条件
     * @return 对象列表
     */
    @PostMapping("queryAllBySysRole")
    @PreAuthorize("hasPermission('/queryAllBySysRole','query_role')")
    public SystemMessage<PageInfo<SysRole>> queryAllBySysRole(@RequestBody SysRole sysRole){
        SystemMessage<PageInfo<SysRole>> result = new SystemMessage<>();
        try{
            PageInfo<SysRole> sysRolePageInfo = this.sysRoleService.queryAllBySysRole(sysRole);
            result.setCode("200");
            result.setData(sysRolePageInfo);
            result.setMsg("成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
        }
        return result;
    }

    /**
     * 通过用户id查询
     *
     * @param uId 用户id
     * @return 对象列表
     */
    @GetMapping("/queryAllByUserId")
    public SystemMessage<List<SysRole>> queryAllByUserId(Integer uId){

        SystemMessage<List<SysRole>> result = new SystemMessage<>();
        try {
            List<SysRole> sysRoles = this.sysRoleService.queryAllByUserId(uId);
            result.setCode("200");
            result.setData(sysRoles);
            result.setMsg("查询成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }

    @PostMapping("/insert")
    @PreAuthorize("hasPermission('/insert','insert_role')")
    SystemMessage<Integer>  insert(@RequestBody SysRole role){
        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            int sysRole = this.sysRoleService.insert(role);
            result.setCode("200");
            result.setData(sysRole);
            result.setMsg("新增成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }


    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @PostMapping("/update")
    @PreAuthorize("hasPermission('/update','edit_role')")
    SystemMessage<Integer> update(SysRole sysRole){
        SystemMessage<Integer> result = new SystemMessage<>();
        try{
            Integer info = this.sysRoleService.update(sysRole);
            result.setCode("200");
            result.setData(info);
            result.setMsg("成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
        }
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */

    @DeleteMapping("/deleteById")
    @PreAuthorize("hasPermission('/deleteById','delete_role')")
    SystemMessage<Integer> deleteById(Integer roleId){
        SystemMessage<Integer> result = new SystemMessage<>();
        try{
            Integer info = this.sysRoleService.deleteById(roleId);
            result.setCode("200");
            result.setData(info);
            result.setMsg("成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
        }
        return result;
    }

}
