package com.jomkie.spring;

import com.jomkie.spring.annotationscan.AnnoScan;
import com.jomkie.spring.demo.config.scan.scanentity.ScannedEntityFirst;
import com.jomkie.spring.demo.free.entity.FreeClass;
import com.jomkie.spring.demo.lookup.ShowFeature;
import com.jomkie.spring.demo.placeholder.PlaceHolderBeanFirst;
import com.jomkie.spring.demo.replace.OriginalRun;
import com.jomkie.spring.entity.User;
import com.jomkie.spring.service.MyFirstService;
import com.jomkie.spring.service.MyFirstServiceImpl;
import lombok.Data;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.ArrayList;

@Data
public class JomkieSpringApplication {

    private String systemName;

    public static void xmlMethod() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        User bean = applicationContext.getBean(User.class);

        // 测试自定义标签
        Object jolabel = applicationContext.getBean("jolabel");
        System.out.println(bean.getUsername());

        // 测试 lookup
        ShowFeature showFeature = applicationContext.getBean(ShowFeature.class);
        showFeature.getFeature().feature();

        // 测试 replace
        OriginalRun originalRun = applicationContext.getBean(OriginalRun.class);
        originalRun.method("Linux");
        originalRun.method(new ArrayList());

        // 测试spring 的注册实例
        FreeClass freeClass = applicationContext.getBean(FreeClass.class);
        System.out.println(freeClass.getUsername());

        // 测试是否获取到了自定义的的 BeanDefiniation 实例
        JomkieSpringApplication registedBeanCustomized = (JomkieSpringApplication) applicationContext.getBean("jomkieSpringApplication");
        System.out.println(registedBeanCustomized.getSystemName());

        // 测试自定义扫描路径进行实例化
        ScannedEntityFirst scannedEntityFirst = applicationContext.getBean(ScannedEntityFirst.class);
        System.out.println(scannedEntityFirst.getUsername());

        // 测试配置文件注册的BeanDefinition的生效情况
        PlaceHolderBeanFirst placeHolderBeanFirst = applicationContext.getBean(PlaceHolderBeanFirst.class);
        System.out.println(placeHolderBeanFirst.getKey());
        System.out.println(placeHolderBeanFirst.getVal());

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = applicationContext.getBean(PropertySourcesPlaceholderConfigurer.class);
        System.out.println(propertySourcesPlaceholderConfigurer);

    }

    public static void annotationMethod() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.jomkie.spring");
    }

    public static void annotationMethod2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnoScan.class);
        // 实验注解aop效果
        MyFirstService myFirstService = (MyFirstService) applicationContext.getBean(MyFirstService.class);
        myFirstService.test();
        // 实验自定义aop效果
        myFirstService.second();
    }

    public static void main(String[] args) {
//        xmlMethod();
//        annotationMethod();
        annotationMethod2();
    }

}
