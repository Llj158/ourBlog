package com.Llj.blog.common.cache;

import java.lang.annotation.*;

/**
 * @description：缓存
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    long expire() default 1 * 60 * 1000;

    String name() default "";

}
