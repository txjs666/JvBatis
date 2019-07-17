package com.jarluo.mybatis.Annotation;

import java.lang.annotation.*;

/**
 * @desc 注解方法，配置sql语句
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    String value();
}
