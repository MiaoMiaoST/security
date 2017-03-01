package com.boot.entity;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Date:2017/2/28 10:10
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
public abstract class AbsSysUser implements UserDetails {
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
}
