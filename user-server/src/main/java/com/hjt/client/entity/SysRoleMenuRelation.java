package com.hjt.client.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色与菜单联表(SysRoleMenuRelation)实体类
 *
 * @author makejava
 * @since 2020-08-17 17:21:30
 */
@Data
public class SysRoleMenuRelation implements Serializable {
    private static final long serialVersionUID = 980828257555207097L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer rId;
    /**
     * 菜单id
     */
    private Integer mId;
}
