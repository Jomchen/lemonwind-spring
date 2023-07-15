package com.jomkie.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 简单实验aop
 */
@Component
@Aspect
public class JomkieAop {

    @Pointcut("execution(public * com.jomkie.spring.service..*(..))")
    public void pot1() {
    }

    @After("pot1()")
    public void afterForJomkieAop() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>afterForJomkieAop");
    }

}
