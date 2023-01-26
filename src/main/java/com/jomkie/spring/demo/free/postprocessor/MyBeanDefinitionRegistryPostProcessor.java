package com.jomkie.spring.demo.free.postprocessor;

import com.jomkie.spring.JomkieSpringApplication;
import com.jomkie.spring.demo.free.annotation.MyComponent;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    // 这个类其实是 DefaultListableBeanFactory
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 手动注入一个类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(JomkieSpringApplication.class);
        MutablePropertyValues mutablePropertyValues = genericBeanDefinition.getPropertyValues();
        mutablePropertyValues.addPropertyValue(new PropertyValue("systemName", "Spring学习系统"));
        registry.registerBeanDefinition("jomkieSpringApplication", genericBeanDefinition);
        System.out.println(" MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry --> " + registry.getClass().getName());

        // 将扫描相应路径下有 @MyComponent 注解的类用于实例化
        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(registry);
        classPathBeanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
        classPathBeanDefinitionScanner.scan("com.jomkie.spring.demo");
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
