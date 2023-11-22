package com.lemonwind.spring.demo.free.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiredCla {

    @Value("${lemonwind.spring.autowired.property}")
    private String autowiredData;

}
