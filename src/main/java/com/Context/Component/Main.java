package com.Context.Component;

import com.Context.Been.JavaConfig;
import com.Context.Been.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        com.Context.Been.Person person = context.getBean(Person.class);
        System.out.println(person.toString());
    }
}