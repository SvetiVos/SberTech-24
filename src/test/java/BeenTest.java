package com.context.been;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeenTest {
    @Test
    public void main() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Person person = context.getBean(Person.class);
        assertEquals("Мур", person.getCat().getCatName());
        assertEquals("ццц", person.getDog().getDogName());
        assertEquals("ююю", person.getParrot1().getParrotName());
        assertEquals("ыыы", person.getParrot2().getParrotName());
    }
}