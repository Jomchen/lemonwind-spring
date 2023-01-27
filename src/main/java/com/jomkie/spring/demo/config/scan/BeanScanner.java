package com.jomkie.spring.demo.config.scan;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(BeanScannerRegister.class)
public @interface BeanScanner {

    String[] value() default {};
    String[] basePackages() default {};
    Class<? extends Annotation> annotationClass() default Annotation.class;

}
