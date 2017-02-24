package com.boot.dao;

import com.boot.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Date:2017/2/24 15:54
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
public interface SysUserDao extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
