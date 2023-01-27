package com.jomkie.spring.demo.free.entity;

import lombok.Data;

/**
 * 自定义类实例化
 */
@Data
public class FreeClass {

    private Long id;
    private String username;
    private Integer age;
    private String address;

    public FreeClass() {
    }

    public FreeClass(Long id, String username, Integer age, String address) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.address = address;
    }

}
