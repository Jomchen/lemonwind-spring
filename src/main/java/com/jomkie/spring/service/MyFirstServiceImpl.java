package com.jomkie.spring.service;

import com.jomkie.spring.annotationscan.CustomAopAnno;
import org.springframework.stereotype.Service;

@Service
public class MyFirstServiceImpl implements MyFirstService {

    public void test() {
        System.out.println("MyFirstService test");
    }

    @CustomAopAnno
    public void second() {
        System.out.println("MyFirstService second");
    }

}
