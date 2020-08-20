package com.example.api.webapi.controller.userServer;

import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.service.userServer.SysUserService;
import com.example.api.webapi.utils.PageInfo;
import com.example.api.webapi.utils.SystemMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@RestController
@RequestMapping("sysUser")
@Api(tags="SysUserController")
public class SysUserController {
    /**
     * 服务对象
     */
    @Autowired
    private SysUserService sysUserService;



    @GetMapping("/queryUserAndRoleAndPermissionAndUrlByName")
    SystemMessage<SysUser> queryUserAndRoleAndPermissionAndUrlByName(@RequestParam("name") String name){
        SystemMessage<SysUser> result = new SystemMessage<>();
        try {
            SysUser sysUser = this.sysUserService.queryUserAndRoleAndPermissionAndUrlByName(name);
            result.setCode("200");
            result.setData(sysUser);
            result.setMsg("成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 条件查询所有
     * @param sys
     * @return 用户集合
     */
    @PostMapping("/queryAllBySysUser")
    @PreAuthorize("hasPermission('/queryAllBySysUser','query_user')")
    SystemMessage<PageInfo<SysUser>>  queryAllBySysUser(@RequestBody SysUser sys){
        SystemMessage<PageInfo<SysUser>> result = new SystemMessage<>();
        try {
            PageInfo<SysUser> sysUserPageInfo = this.sysUserService.queryAllBySysUser(sys);
            sysUserPageInfo.getList().forEach(
                    sysUser -> {
                        sysUser.setPassword("");
                    }
            );
            result.setCode("200");
            result.setData(sysUserPageInfo);
            result.setMsg("成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 路径拦截权限的名称必须与权限列表注册的一样，经过测试，使用hasRole的注解， 方法级别的注解权限需要
     * ROLE_前缀 ，因此，路径拦截权限的名称、注解权限名称、数据库存储的权限名称都要加
     * ROLE_前缀最好，避免出现错误， 如果数据库的权限名称不加ROLE_前缀，那么在注册权
     * 限列表的时候记得拼接ROLE_前缀。
     * 如果不想麻烦，可以使用 hasAuthority ，不需要添加前缀，
     * 不论是那种方法，注解的限制效果和在security配置文件设置的效果是一样的。
     * @param sysUser
     * @return
     */
    @PostMapping("/insert")
    @PreAuthorize("hasPermission('/insert','create_user')")
    SystemMessage<Integer>  insert(@RequestBody SysUser sysUser){
        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            int user = this.sysUserService.insert(sysUser);
            result.setCode("200");
            result.setData(user);
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
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @PostMapping("/update")
    @PreAuthorize("hasPermission('/update','edit_user')")
    SystemMessage<Integer> update(SysUser sysUser){
        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            int user = this.sysUserService.update(sysUser);
            result.setCode("200");
            result.setData(user);
            result.setMsg("修改成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @DeleteMapping("/deleteById")
    @PreAuthorize("hasPermission('/deleteById','delete_user')")
    SystemMessage<Integer> deleteById(Integer userId){
        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            int user = this.sysUserService.deleteById(userId);
            result.setCode("200");
            result.setData(user);
            result.setMsg("删除成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }
}
