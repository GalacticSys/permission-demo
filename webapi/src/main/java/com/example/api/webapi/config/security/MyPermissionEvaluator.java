package com.example.api.webapi.config.security;

import com.example.api.webapi.entity.MyUserRole;
import com.example.api.webapi.entity.userServer.SysPermission;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyPermissionEvaluator implements PermissionEvaluator {

    /**
     * hasPermission鉴权方法
     * 这里仅仅判断PreAuthorize注解中的权限表达式
     * 实际中可以根据业务需求设计数据库通过targetUrl和permission做更复杂鉴权
     * 当然targetUrl不一定是URL可以是数据Id还可以是管理员标识等,这里根据需求自行设计
     * @Author Sans
     * @CreateTime 2019/10/6 18:25
     * @Param  authentication  用户身份(在使用hasPermission表达式时Authentication参数默认会自动带上)
     * @Param  targetUrl  请求路径
     * @Param  permission 请求路径权限
     * @Return boolean 是否通过
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {
        boolean result =false;
        System.out.println("MyPermissionEvaluator-================");
        System.out.println(authentication);
        List<MyUserRole> authorities = (List<MyUserRole>) authentication.getAuthorities();
        List<SysPermission> sysPermissions = new ArrayList<>();
        authorities.forEach(
                myUserRole -> {
                    System.out.println(myUserRole.getSysRole());
                    sysPermissions.addAll(myUserRole.getSysRole().getSysPermissions());
                }
        );
        for (SysPermission sysPermission : sysPermissions) {
            if ("*".equals(sysPermission.getPermissionCode()) || sysPermission.getPermissionCode().equals(permission.toString())){
                System.out.println("拥有该接口权限");
                result=true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
