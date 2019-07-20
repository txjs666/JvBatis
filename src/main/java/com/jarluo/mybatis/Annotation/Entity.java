package com.jarluo.mybatis.Annotation;

import java.lang.annotation.*;

/**
 * @desc
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
    Class<?> value();
}
