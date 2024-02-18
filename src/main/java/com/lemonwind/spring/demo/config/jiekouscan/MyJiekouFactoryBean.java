package com.lemonwind.spring.demo.config.jiekouscan;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Proxy;

public class MyJiekouFactoryBean implements FactoryBean {

    private Class<?> interfaceCla;
    private ApplicationContext applicationContext;

    public MyJiekouFactoryBean(Class<?> interfaceCla) {
        this.interfaceCla = interfaceCla;
    }

    @Override
    public Object getObject() {
        return Proxy.newProxyInstance(interfaceCla.getClassLoader(), new Class[]{interfaceCla}, new MyInvocationHandler());
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceCla;
    }

}
