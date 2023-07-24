package com.jomkie.spring.aop.custom;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;


/**
 * 自定义增强器
 */
@Component
public class CustomAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("自定义AOP调用前---------->Start");
        Object result = invocation.proceed();
        System.out.println("自定义AOP调用后---------->End");
        return result;
    }

}
