package com.jomkie.spring.annotationscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.jomkie.spring")
@EnableAspectJAutoProxy
public class AnnoScan {
}
