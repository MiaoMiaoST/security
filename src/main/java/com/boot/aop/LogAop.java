package com.boot.aop;

import com.boot.annotation.LogAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Date:2017/2/28 17:07
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Aspect
@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LogAop {
    private final Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Pointcut(value = "@annotation(log)", argNames = "log")
    public void logPointcut(LogAspect log) {
    }

    @Before(value = "logPointcut(log)", argNames = "joinPoint, log")
    public void beforeAction(JoinPoint joinPoint, LogAspect log) {
        logger.info("调用前置方法拦截，参数为：" + log.value());
    }

    @Around(value = "logPointcut(log)", argNames = "pJoinPoint, log")
    public Object aroundAction(ProceedingJoinPoint pJoinPoint, LogAspect log) throws Throwable{
        logger.info("1.调用环绕方法拦截，参数为：" + log.value());
        Object result = pJoinPoint.proceed();
        logger.info("2.调用环绕方法拦截，参数为：");
        return result;
    }

    @After(value = "logPointcut(log)", argNames = "joinPoint, log")
    public void afterAction(JoinPoint joinPoint, LogAspect log) {
        logger.info("调用后置方法拦截，参数为：" + log.value());
    }
}
