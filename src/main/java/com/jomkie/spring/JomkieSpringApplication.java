package com.jomkie.spring;

import com.jomkie.spring.demo.free.FreeClass;
import com.jomkie.spring.demo.lookup.ShowFeature;
import com.jomkie.spring.demo.replace.OriginalRun;
import com.jomkie.spring.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class JomkieSpringApplication {

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
    }

}
