package com.context.component;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    @Test
    public void main() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Person person = context.getBean(Person.class);
        Person testPerson = new Person(new Parrot(), new Parrot(), new Cat(), new Dog();
        Assert.assertEquals(testPerson, person);
    }
}