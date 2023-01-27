package com.jomkie.spring;

import com.jomkie.spring.demo.config.scan.scanentity.ScannedEntityFirst;
import com.jomkie.spring.demo.free.entity.FreeClass;
import com.jomkie.spring.demo.lookup.ShowFeature;
import com.jomkie.spring.demo.replace.OriginalRun;
import com.jomkie.spring.entity.User;
import lombok.Data;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

@Data
public class JomkieSpringApplication {

    private String systemName;

    @Test
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.getUsername());

        // 测试 lookup
        ShowFeature showFeature = applicationContext.getBean(ShowFeature.class);
        showFeature.getFeature().feature();

        // 测试 replace
        OriginalRun originalRun = applicationContext.getBean(OriginalRun.class);
        originalRun.method("Linux");
        originalRun.method(new ArrayList());

       FreeClass freeClass = applicationContext.getBean(FreeClass.class);
       System.out.println(freeClass.getUsername());

       // 测试是否获取到了自定义的的 BeanDefiniation 实例
       JomkieSpringApplication registedBeanCustomized = (JomkieSpringApplication) applicationContext.getBean("jomkieSpringApplication");
       System.out.println(registedBeanCustomized.getSystemName());

       // 测试自定义扫描路径进行实例化
       ScannedEntityFirst scannedEntityFirst = applicationContext.getBean(ScannedEntityFirst.class);
       System.out.println(scannedEntityFirst.getUsername());

    }

}
