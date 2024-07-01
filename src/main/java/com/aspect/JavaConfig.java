package com.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {

    @Bean
    public NotEmptyAspect notEmptyAspect() {
        return new NotEmptyAspect();
    }
}
