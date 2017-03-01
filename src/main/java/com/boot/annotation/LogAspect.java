package com.boot.annotation;

import java.lang.annotation.*;

/**
 * Date:2017/2/28 17:18
 * <p>
 * Author:zgj
 * <p>
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAspect {
    String value() default "";
}
