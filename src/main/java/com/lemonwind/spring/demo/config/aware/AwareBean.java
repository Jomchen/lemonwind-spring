package com.lemonwind.spring.demo.config.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * 实现相应的接口，可以实现获取，类名，类工厂，环境，上下文，导入策略
 */
public class AwareBean implements BeanNameAware, BeanFactoryAware, EnvironmentAware, ApplicationContextAware, ImportAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        // 这里的 importMetadata 可以获取使用 @Import 导入当前类的的类的所有注解
        MergedAnnotations mergedAnnotations = importMetadata.getAnnotations();
    }
}
