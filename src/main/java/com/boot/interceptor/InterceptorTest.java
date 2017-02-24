package com.boot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date:2017/2/24 8:56
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
public class InterceptorTest extends HandlerInterceptorAdapter{
    Logger logger = LoggerFactory.getLogger(InterceptorTest.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(String.format("拦截咯:%s", request.getRequestURL()));
        return true;
    }
}
