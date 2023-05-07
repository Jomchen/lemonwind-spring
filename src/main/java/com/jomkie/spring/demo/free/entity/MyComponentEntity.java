package com.jomkie.spring.demo.free.entity;

import com.jomkie.spring.demo.free.annotation.MyComponent;
import lombok.Data;

/**
 * 自定义注解的扫描类并实例化
 */
@Data
@MyComponent
public class MyComponentEntity {
    private String username = "自定义";
}
