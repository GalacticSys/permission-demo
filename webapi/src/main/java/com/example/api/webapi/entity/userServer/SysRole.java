package com.example.api.webapi.entity.userServer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 用户角色表(SysRole)实体类
 *
 * @author makejava
 * @since 2020-08-05 01:12:44
 */
@Data
public class SysRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -88777016283825172L;
    /**
     * 主键id
     */
    private Integer roleId;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色说明
     */
    private String roleDescription;
    /**
     * 角色名
     */
    private String roleCode;
    /**
     * 权限
     */
    List<SysPermission> sysPermissions;

    /**
     * 菜单
     */
    List<SysMenu> sysMenus;
}
