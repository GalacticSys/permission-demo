package com.hjt.client.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 菜单表(SysMenu)实体类
 *
 * @author makejava
 * @since 2020-08-17 17:21:28
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 729319510275374401L;
    /**
     * 主键
     */
    private Integer menuId;
    /**
     * 路径
     */
    private String menuPath;
    /**
     * 父id
     */
    private Integer menuParentId;
    /**
     * 菜单名称
     */
    private String menuName;
}
