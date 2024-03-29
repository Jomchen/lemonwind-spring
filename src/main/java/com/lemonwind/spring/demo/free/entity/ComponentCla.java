package com.lemonwind.spring.demo.free.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 这个类只适用于测试 扫描
 */
@Component
@Data
public class ComponentCla {

    private String description = "独孤求败";

    @Autowired
    private AutowiredCla autowiredCla;

}
