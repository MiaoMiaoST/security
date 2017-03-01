package com.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Date:2017/2/28 9:57
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Entity
public class SysMenu {
    @Id
    @GeneratedValue
    private Long id;
    private String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
