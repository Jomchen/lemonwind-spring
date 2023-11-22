package com.lemonwind.spring.annotationscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.lemonwind.spring")
@EnableAspectJAutoProxy
public class AnnoScan {
}
