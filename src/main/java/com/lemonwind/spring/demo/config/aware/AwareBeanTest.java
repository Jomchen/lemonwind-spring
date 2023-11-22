package com.lemonwind.spring.demo.config.aware;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(AwareBean.class)
public class AwareBeanTest {
}
