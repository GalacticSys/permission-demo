package com.example.api.webapi.entity;

import com.example.api.webapi.entity.userServer.SysUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class MyUserDetails implements UserDetails {
    private SysUser sysUser;
    private List<MyUserRole> authorities;

    //获取角色的集合
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // 获取密码
    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    // 获取用户名
    @Override
    public String getUsername() {
        return sysUser.getUserName();
    }

    // 帐号是否过期
    @Override
    public boolean isAccountNonExpired() {
        if (sysUser.getNotExpired()){
            return false;
        }
        else {
            return true;
        }
    }

    // 帐号是否锁定
    @Override
    public boolean isAccountNonLocked() {
        if (sysUser.getAccountNotLocked()){
            return false;
        }
        else {
            return true;
        }
    }

    // 密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        if (sysUser.getCredentialsNotExpired()){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "MyUserDetails{" +
                "sysUser=" + sysUser +
                ", authorities=" + authorities +
                '}';
    }
}
