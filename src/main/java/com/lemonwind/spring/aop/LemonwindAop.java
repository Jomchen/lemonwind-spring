package com.lemonwind.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 简单实验aop
 */
@Component
@Aspect
public class LemonwindAop {

    @Pointcut("execution(public * com.lemonwind.spring.service..*(..))")
    public void pot1() {
    }

    @After("pot1()")
    public void afterForLemonwindAop() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>afterForLemonwindAop");
    }

}
