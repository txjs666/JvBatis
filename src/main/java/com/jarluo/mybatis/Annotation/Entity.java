package com.jarluo.mybatis.Annotation;

import java.lang.annotation.*;

/**
 * @desc
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Entity {
    String value();
}
