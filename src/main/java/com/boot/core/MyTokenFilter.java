package com.boot.core;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Date:2017/3/1 10:22
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
public class MyTokenFilter extends GenericFilterBean {
    /**
     * 携带Token的HTTP头
     */
    public static final String TOKEN_HEADER = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authHeader = httpRequest.getHeader(TOKEN_HEADER);

        System.out.println("head是个啥：" + authHeader);
//        if (authHeader == null || !authHeader.startsWith(AbstractTokenUtil.TOKEN_TYPE_BEARER)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        final String authToken = StringHelper.substring(authHeader, 7);
//        String username = StringHelper.isNotBlank(authToken) ? jwtTokenUtil.getUsernameFromToken(authToken) : null;
//
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null && jwtTokenUtil.validateToken(authToken)) {
//            UserDetails userDetails = jwtTokenUtil.getUserDetails(authToken);
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }

        chain.doFilter(request, response);
    }
}
