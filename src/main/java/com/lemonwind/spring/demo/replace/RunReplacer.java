package com.lemonwind.spring.demo.replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class RunReplacer implements MethodReplacer {

    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("class: " + obj.getClass().getName());
        System.out.println("methodName: " + method.getName());
        System.out.println("I am replacer");
        return null;
    }

}
