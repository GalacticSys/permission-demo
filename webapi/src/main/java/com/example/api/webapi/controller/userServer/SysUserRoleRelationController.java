package com.example.api.webapi.controller.userServer;

import com.example.api.webapi.entity.userServer.SysUserRoleRelation;
import com.example.api.webapi.service.userServer.SysUserRoleRelationService;
import com.example.api.webapi.utils.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户角色关联关系表(SysUserRoleRelation)表控制层
 *
 * @author makejava
 * @since 2020-08-05 01:41:06
 */
@RestController
@RequestMapping("sysUserRoleRelation")
public class SysUserRoleRelationController {
    /**
     * 服务对象
     */
    @Autowired
    private SysUserRoleRelationService sysUserRoleRelationService;

    /**
     * 添加数据
     *
     * @param sysUserRoles 实体集合
     * @return 影响行数
     */
    @PostMapping("/insertAll")
    public SystemMessage<Integer> insertAll(@RequestBody List<SysUserRoleRelation> sysUserRoles) {
        SystemMessage<Integer> result = new SystemMessage<>();
        try {
            Integer integer = this.sysUserRoleRelationService.insertAll(sysUserRoles);
            result.setCode("200");
            result.setData(integer);
            result.setMsg("分配成功");
        }catch (Exception e) {
            e.printStackTrace();
            result.setCode("500");
            result.setMsg("服务器出错");
        }
        return result;
    }
}
