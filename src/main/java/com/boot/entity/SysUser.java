package com.boot.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Date:2017/2/24 15:51
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Entity
public class SysUser extends AbsSysUser{
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysRole> roles;

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = this.roles.stream().map(sysRole -> new SimpleGrantedAuthority(sysRole.getName())).collect(Collectors.toList());
        this.roles.stream().forEach(roleTemp -> roleTemp.getMenus().forEach(sysMenu -> list.add(new SimpleGrantedAuthority(sysMenu.getPermission()))));
        return list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}
