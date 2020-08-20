package com.example.api.webapi.service;

import com.example.api.webapi.client.userServer.SysUserClient;
import com.example.api.webapi.entity.MyUserDetails;
import com.example.api.webapi.entity.MyUserRole;
import com.example.api.webapi.entity.userServer.SysMenu;
import com.example.api.webapi.entity.userServer.SysRole;
import com.example.api.webapi.entity.userServer.SysUser;
import com.example.api.webapi.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SysUserClient sysUserClient;

    @Autowired
    TreeUtils treeUtils;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("登录验证");
            SysUser sysUser = sysUserClient.queryUserAndRoleAndPermissionAndUrlByName(username);
            if (sysUser!=null){
                MyUserDetails myUserDetails = new MyUserDetails();
                //处理权限
                List<MyUserRole> authorities = new ArrayList<>();
                //处理菜单
                List<SysMenu> sysMenus = this.menuHandel(sysUser.getSysRoles());
                sysUser.getSysRoles().forEach(
                        sysRole -> {
                            authorities.add(new MyUserRole(sysRole));
                        }
                );
                sysUser.setSysMenus(sysMenus);
                myUserDetails.setSysUser(sysUser);
                myUserDetails.setAuthorities(authorities);
                return myUserDetails;
            }throw new UsernameNotFoundException("用户不存在");
    }

    public List<SysMenu> menuHandel(List<SysRole> roleList){
        List<SysMenu> result = new ArrayList<>();
        roleList.forEach(
                role->{
                    List<SysMenu> list = treeUtils.parentIdAll(role.getSysMenus());
                    list.forEach(
                            l->{
                                List<SysMenu> build = treeUtils.build(role.getSysMenus(), l.getMenuId());
                                l.setChildren(build);
                            }
                    );
                    result.addAll(role.getSysMenus());
                }
        );
        List<SysMenu> collect = result.stream().distinct().collect(Collectors.toList());
        List<SysMenu> sysMenuStream = collect.stream().filter(
                c -> !CollectionUtils.isEmpty(c.getChildren())
        ).collect(Collectors.toList());

        return sysMenuStream;
    }

}
