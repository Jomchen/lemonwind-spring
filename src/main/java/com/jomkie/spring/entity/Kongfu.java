package com.jomkie.spring.entity;

import lombok.Data;

/**
 * 功夫
 */
@Data
public class Kongfu {

    /** 名字 */
    private String name;

    /** 等级 */
    private Integer level;

    /** 发明人 */
    private User user;

}
