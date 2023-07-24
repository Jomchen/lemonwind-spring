package com.jomkie.spring.aop.custom;

import com.jomkie.spring.annotationscan.CustomAopAnno;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义切点
 */
@Component
public class CustomPointcut implements Pointcut, MethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> targetClass) {

        Method noBridgeMethod = AopUtils.getMostSpecificMethod(method, targetClass);
        return noBridgeMethod.isAnnotationPresent(CustomAopAnno.class);
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }

}
