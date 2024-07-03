package com.context.component;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    @Test
    public void main() {
        Parrot parrot1 = new Parrot();
        parrot1.setParrotName("Parrot1");

        Parrot parrot2 = new Parrot();
        parrot2.setParrotName("Parrot2");

        Cat cat = new Cat();
        cat.setCatName("Cat");

        Dog dog = new Dog();
        dog.setDogName("Dog");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Person person = context.getBean(Person.class);

        assertEquals("Parrot1", person.getParrot1().getParrotName());
        assertEquals("Parrot2", person.getParrot2().getParrotName());
        assertEquals("Cat", person.getCat().getCatName());
        assertEquals("Dog", person.getDog().getDogName());
    }
}