package com.jomkie.spring.demo.config.scan;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

public class BeanPackageScanner extends ClassPathBeanDefinitionScanner {

    public BeanPackageScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolderSet = super.doScan(basePackages);
        return beanDefinitionHolderSet;
    }


}
