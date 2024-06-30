package com.context.been;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeenTest {
    @Test
    public void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Person person = context.getBean(Person.class);
        person.getCat().setCatName("Мур");
        String string = person.getCat().getCatName();
        String expect = "Мур";
        assertEquals(string, expect);

    }
}