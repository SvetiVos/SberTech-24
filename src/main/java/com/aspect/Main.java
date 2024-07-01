package com.aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Example example = context.getBean(Example.class);

        try {
            example.doSomething("test", null);
            example.doSomething("", Collections.emptyList());
            example.doSomething("test", Arrays.asList("a"));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
