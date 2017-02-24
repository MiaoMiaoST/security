package com.boot.service;

import com.boot.dao.SysUserDao;
import com.boot.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Date:2017/2/24 15:37
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserDao sysUserDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = sysUserDao.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
