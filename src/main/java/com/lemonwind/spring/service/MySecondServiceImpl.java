package com.lemonwind.spring.service;

import org.springframework.stereotype.Service;

@Service
public class MySecondServiceImpl implements MySecondService {

    @Override
    public void secondHandler() {
        System.out.println("secondHandler");
    }

}
