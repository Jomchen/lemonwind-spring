package com.jomkie.spring.demo.free;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        List<BeanDefinition> list = new ArrayList<>();
        for (String bd : beanDefinitionNames) {
            BeanDefinition bbdd = beanFactory.getBeanDefinition(bd);
            list.add(bbdd);
        }
        System.out.println(list);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
