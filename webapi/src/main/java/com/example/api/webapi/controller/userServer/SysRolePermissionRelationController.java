package com.example.api.webapi.controller.userServer;

import com.example.api.webapi.entity.userServer.SysRolePermissionRelation;
import com.example.api.webapi.service.userServer.SysRolePermissionRelationService;
import com.example.api.webapi.utils.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@RestController
@RequestMapping("sysRolePermissionRelation")
public class SysRolePermissionRelationController {
    /**
     * 服务对象
     */
    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    /**
     * 添加数据
     *
     * @param sysUserRoleRelations 实体集合
     * @return 影响行数
     */
    @PostMapping("insertAll")
    public  SystemMessage<Integer> insertAll(@RequestBody List<SysRolePermissionRelation> sysUserRoleRelations){

        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            Integer info = this.sysRolePermissionRelationService.insertAll(sysUserRoleRelations);
            result.setCode("200");
            result.setData(info);
            result.setMsg("成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }
}
