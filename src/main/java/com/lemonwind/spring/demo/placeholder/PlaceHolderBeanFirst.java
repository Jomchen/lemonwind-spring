package com.lemonwind.spring.demo.placeholder;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class PlaceHolderBeanFirst {

    private String key = "first";
    @Value("${lemonwind.spring.autowired.property}")
    private String val;

}
