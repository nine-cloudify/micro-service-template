package com.nine.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author wangjia
 * @date 2018-11-23
 */
@Data
public class RoleDTO implements Serializable {

    private Long id;

    private String name;

    private String dataScope;

    private Integer level;

    private String remark;

    private Set<PermissionDTO> permissions;

    private Set<MenuDTO> menus;

    private Timestamp createTime;
}
