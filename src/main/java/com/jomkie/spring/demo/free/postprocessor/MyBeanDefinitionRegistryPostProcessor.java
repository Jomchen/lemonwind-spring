package com.jomkie.spring.demo.free.postprocessor;

import com.jomkie.spring.JomkieSpringApplication;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    // 这个类其实是 DefaultListableBeanFactory
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 手动注入一个类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(JomkieSpringApplication.class);
        registry.registerBeanDefinition("jomkieSpringApplication", genericBeanDefinition);
        System.out.println(" MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry --> " + registry.getClass().getName());
    }

    // 这个类其实是 DefaultListableBeanFactory
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(" MyBeanDefinitionRegistryPostProcessor postProcessBeanFactory --> " + beanFactory.getClass().getName());
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
