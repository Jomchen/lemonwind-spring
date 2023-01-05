package com.jomkie.spring.entity;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String username = "Jomkie";
    private Integer age;
    private String address;

}
