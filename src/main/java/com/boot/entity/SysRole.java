package com.boot.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Date:2017/2/24 15:50
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysMenu> menus;

    public List<SysMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenu> menus) {
        this.menus = menus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
