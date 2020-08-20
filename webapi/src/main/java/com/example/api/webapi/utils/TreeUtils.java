package com.example.api.webapi.utils;

import com.example.api.webapi.entity.userServer.SysMenu;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class TreeUtils {
    public static List<SysMenu> sysMenus = new ArrayList<>();
    static {
        SysMenu sysMenu1 = new SysMenu();
        sysMenu1.setMenuId(1);
        sysMenu1.setMenuName("权限管理");
        sysMenu1.setMenuPath("/");
        sysMenu1.setMenuParentId(0);

        SysMenu sysMenu2 = new SysMenu();
        sysMenu2.setMenuId(2);
        sysMenu2.setMenuName("用户列表");
        sysMenu2.setMenuPath("query_user");
        sysMenu2.setMenuParentId(1);

        SysMenu sysMenu3 = new SysMenu();
        sysMenu3.setMenuId(3);
        sysMenu3.setMenuName("角色列表");
        sysMenu3.setMenuPath("query_role");
        sysMenu3.setMenuParentId(1);

        SysMenu sysMenu4 = new SysMenu();
        sysMenu4.setMenuId(4);
        sysMenu4.setMenuName("权限列表");
        sysMenu4.setMenuPath("query_permission");
        sysMenu4.setMenuParentId(1);

        SysMenu sysMenu5 = new SysMenu();
        sysMenu5.setMenuId(5);
        sysMenu5.setMenuName("商品管理");
        sysMenu5.setMenuPath("/");
        sysMenu5.setMenuParentId(0);

        SysMenu sysMenu6 = new SysMenu();
        sysMenu6.setMenuId(6);
        sysMenu6.setMenuName("商品列表");
        sysMenu6.setMenuPath("query_goods");
        sysMenu6.setMenuParentId(5);

        sysMenus.add(sysMenu1);
        sysMenus.add(sysMenu2);
        sysMenus.add(sysMenu3);
        sysMenus.add(sysMenu4);
        sysMenus.add(sysMenu5);
        sysMenus.add(sysMenu6);
    }
    public List<SysMenu> parentIdAll(List<SysMenu> sysMenus){
        List<SysMenu> parentIds = new ArrayList<>();
        sysMenus.forEach(
                sysMenu -> {
                    if (sysMenu.getMenuParentId()==0){
                        parentIds.add(sysMenu);
                    }
                }
        );
        return parentIds;
    }
    public List<SysMenu> build(List<SysMenu> sysMenus,Integer parentId){
        List<SysMenu> children = new ArrayList<>();
        for (SysMenu sysMenu : sysMenus) {
            if (sysMenu.getMenuParentId()==parentId){
                List<SysMenu> child = build(sysMenus,sysMenu.getMenuId());
                if (child.size()>0){
//                    SysMenu sysMenu1 = new SysMenu();
//                    sysMenu1.setMenuName(sysMenu.getMenuName());
//                    sysMenu1.setChildren(child);
                    children.add(sysMenu);
                }else {
//                    SysMenu sysMenu1 = new SysMenu();
//                    sysMenu1.setMenuName(sysMenu.getMenuName());
                    children.add(sysMenu);
                }
            }
        }
        return children;
    }

//    public static void main(String[] args) {
//        TreeUtils treeUtils = new TreeUtils();
//        List<SysMenu> list = treeUtils.parentIdAll(sysMenus);
//        for (SysMenu sysMenu : list) {
//            List<SysMenu> build = treeUtils.build(sysMenus, sysMenu.getMenuId());
//            sysMenu.setChildren(build);
//            System.out.println(sysMenu);
//        }
//    }
}
