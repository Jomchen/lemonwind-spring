package com.lemonwind.spring.demo.config.jiekouscan;

public class MyJiekouSecond implements MyJiekou{
    @Override
    public String kanData() {
        System.out.println("第二个实现");
        return "第二个";
    }
}
