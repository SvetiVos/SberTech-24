package com.context.component;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    @Test
    public void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        com.context.component.Person person = context.getBean(Person.class);
        person.getCat().setCatName("Мур");
        String string = person.getCat().getCatName();
        String expect = "Мур";
        assertEquals(string, expect);

    }
}