package com.lemonwind.spring.annotationscan;

import com.lemonwind.spring.demo.config.jiekouscan.MyJiekouRegister;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.lemonwind.spring")
@EnableAspectJAutoProxy
@Import(MyJiekouRegister.class)
public class AnnoScan {
}
