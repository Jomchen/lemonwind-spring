package com.lemonwind.spring.demo.config.jiekouscan;

public class MyJiekouFirst implements MyJiekou {
    @Override
    public String kanData() {
        System.out.println("第一个实现");
        return "第一个";
    }
}
