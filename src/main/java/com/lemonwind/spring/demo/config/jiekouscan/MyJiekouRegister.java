package com.lemonwind.spring.demo.config.jiekouscan;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;


/**
 * 验证对接口的扫描，并对接口实行代理
 */
public class MyJiekouRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MyJiekouScanner myJiekouScanner = new MyJiekouScanner(registry);
        myJiekouScanner.addIncludeFilter(new AnnotationTypeFilter(JieKouAnno.class));
        myJiekouScanner.scan("com.lemonwind.spring");

        String[] ss = registry.getBeanDefinitionNames();
        for (String s : ss) {
            System.out.println(s + "--------------------------------");
        }
    }
}
