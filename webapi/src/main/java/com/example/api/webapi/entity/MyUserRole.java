package com.example.api.webapi.entity;

import com.example.api.webapi.entity.userServer.SysRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUserRole implements GrantedAuthority {
    private SysRole sysRole;


    public SysRole getSysRole() {
        return sysRole;
    }

    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }
    //getAuthority 这个方法返回的是 你的角色代码 就类似于这种ROLE_user
    @Override
    public String getAuthority() {
        return sysRole.getRoleCode();
    }
}




