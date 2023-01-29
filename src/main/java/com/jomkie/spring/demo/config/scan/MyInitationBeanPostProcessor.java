package com.jomkie.spring.demo.config.scan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

/**
 * 这个用于解决类进行实例化后，内部的引用是否进行注入的判断
 */
@Component
public class MyInitationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return super.postProcessAfterInstantiation(bean, beanName);
    }

}
