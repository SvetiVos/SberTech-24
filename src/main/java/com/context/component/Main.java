package com.context.component;

import com.context.component.JavaConfig;
import com.context.component.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        com.context.component.Person person = context.getBean(Person.class);
        System.out.println(person.toString());
    }
}