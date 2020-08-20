package com.example.api.webapi.entity.userServer;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限表(SysPermission)实体类
 *
 * @author makejava
 * @since 2020-08-05 01:12:40
 */
@Data
public class SysPermission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 808757204945427993L;
    /**
     * 主键id
     */
    private Integer permissionId;
    /**
     * 权限code
     */
    private String permissionCode;
    /**
     * 权限名
     */
    private String permissionName;
}
