package com.jomkie.spring.aop.custom;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自定义切面
 * 这种方式是全局性代理，这样影响性能
 */
@Component
public class CustomAdvisor implements PointcutAdvisor {

    @Autowired
    private CustomPointcut customPointcut;
    @Autowired
    private CustomAdvice customAdvice;


    @Override
    public Pointcut getPointcut() {
        return customPointcut;
    }

    @Override
    public Advice getAdvice() {
        return customAdvice;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }

}
