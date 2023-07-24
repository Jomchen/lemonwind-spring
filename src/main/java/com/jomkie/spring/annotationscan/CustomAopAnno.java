package com.jomkie.spring.annotationscan;

import java.lang.annotation.*;

/**
 * 自定义AOP注解，拦截所有有注解的方法
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface CustomAopAnno {
}
