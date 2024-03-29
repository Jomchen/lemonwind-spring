package com.lemonwind.spring.demo.free.postprocessor;

import com.lemonwind.spring.LemonwindSpringApplication;
import com.lemonwind.spring.demo.free.annotation.MyComponent;
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
import org.springframework.stereotype.Component;

/**
 * 手动加入一个 自定义BeanDefinition
 *
 * 通过扫描自定义的注解进行注册 BeanDefinition
 * 对指定注解的类进行实例化
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    // 这个类其实是 DefaultListableBeanFactory
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 手动注入一个类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(LemonwindSpringApplication.class);
        MutablePropertyValues mutablePropertyValues = genericBeanDefinition.getPropertyValues();
        mutablePropertyValues.addPropertyValue(new PropertyValue("systemName", "Spring学习系统"));
        registry.registerBeanDefinition("lemonwindSpringApplication", genericBeanDefinition);
        System.out.println(" MyBeanDefinitionRegistryPostProcessor postProcessBeanDefinitionRegistry --> " + registry.getClass().getName());

        // 将扫描相应路径下有 @MyComponent 注解的类用于实例化
        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(registry);
        classPathBeanDefinitionScanner.addIncludeFilter(new AnnotationTypeFilter(MyComponent.class));
        classPathBeanDefinitionScanner.scan("com.lemonwind.spring.demo");
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
