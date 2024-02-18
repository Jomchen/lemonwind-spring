package com.lemonwind.spring.demo.config.jiekouscan;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {


    public MyInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("代理哦");
        return "Linux";
    }
}
