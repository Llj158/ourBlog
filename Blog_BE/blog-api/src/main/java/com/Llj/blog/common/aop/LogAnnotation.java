package com.Llj.blog.common.aop;

import java.lang.annotation.*;

/**
 * @description：
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String module() default "";

    String operator() default "";
}
