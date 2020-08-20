package com.hjt.client.entity;

import java.io.Serializable;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)实体类
 *
 * @author makejava
 * @since 2020-08-05 01:12:44
 */
public class SysRolePermissionRelation implements Serializable {
    private static final long serialVersionUID = -10832874301889572L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}
