package com.example.api.webapi.entity.userServer;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-08-05 01:12:44
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 437793064537862952L;

    private Integer userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 上一次登录时间
     */
    private Date lastLoginTime;
    /**
     * 账号是否可用。默认为1（可用）
     */
    private Boolean enabled;
    /**
     * 是否过期。默认为0（没有过期）
     */
    private Boolean notExpired;
    /**
     * 账号是否锁定。默认为0（没有锁定）
     */
    private Boolean accountNotLocked;
    /**
     * 证书（密码）是否过期。默认为0（没有过期）
     */
    private Boolean credentialsNotExpired;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 角色
     */
    List<SysRole> sysRoles;

    /**
     * 菜单
     */
    List<SysMenu> sysMenus;

    /**
     * 分页
     */
    private Integer start;
    private Integer rows;
    private String sort;

}
