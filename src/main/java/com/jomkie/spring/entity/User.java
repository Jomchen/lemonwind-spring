package com.jomkie.spring.entity;

import lombok.Data;

/**
 * 人
 */
@Data
public class User {

    /** ID */
    private Long id;

    /** 用户名 */
    private String username;

    /** 年龄 */
    private Integer age;

    /** 地址 */
    private String address;

}
