package com.boot.core;

import com.boot.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Date:2017/2/24 15:58
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Bean
    public MyTokenFilter tokenFilterBean() {
        return new MyTokenFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/home/aop").defaultSuccessUrl("/home/test", true).failureUrl("/login?error").permitAll()
                .and().logout().permitAll();
        http.addFilterBefore(tokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**");
    }
}
