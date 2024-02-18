package com.lemonwind.spring.demo.config.jiekouscan;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

import java.util.Set;

public class MyJiekouScanner extends ClassPathBeanDefinitionScanner {

    public MyJiekouScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }


    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> set = super.doScan(basePackages);
        for (BeanDefinitionHolder b : set) {
            ScannedGenericBeanDefinition ss = (ScannedGenericBeanDefinition)b.getBeanDefinition();
            String beanClassName = ss.getBeanClassName();
            ss.setBeanClass(MyJiekouFactoryBean.class);
            ss.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
            ss.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        }
        return set;
    }
}
