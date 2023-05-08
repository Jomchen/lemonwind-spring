package com.jomkie.spring.demo.placeholder;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class PlaceHolderBeanFirst {

    private String key = "first";
    @Value("${jomkie.spring.autowired.property}")
    private String val;

}
