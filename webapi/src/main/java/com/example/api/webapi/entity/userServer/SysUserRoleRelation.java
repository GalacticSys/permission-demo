package com.example.api.webapi.entity.userServer;

import java.io.Serializable;

/**
 * 用户角色关联关系表(SysUserRoleRelation)实体类
 *
 * @author makejava
 * @since 2020-08-05 01:12:44
 */
public class SysUserRoleRelation implements Serializable {
    private static final long serialVersionUID = -26197519899270319L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 角色id
     */
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
