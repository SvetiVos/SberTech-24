package com.context.component;

import com.context.component.Cat;
import com.context.component.Dog;
import com.context.component.Parrot;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.*;

@Data
@Component
public class Person {
    private String personName;
    @Autowired
    private final com.context.component.Parrot parrot1;
    @Autowired
    private final com.context.component.Parrot parrot2;
    @Autowired
    private final com.context.component.Cat cat;
    @Autowired
    private final com.context.component.Dog dog;


    public Person(com.context.component.Parrot parrot1, Parrot parrot2, Cat cat, Dog dog) {
        this.parrot1 = parrot1;
        this.parrot2 = parrot2;
        this.cat = cat;
        this.dog = dog;
    }

    @Override
    public String toString(){
        return "Person {" + "parrot1 = " + parrot1 + ", parrot2 = " + parrot2 +
                ", cat = " + cat + ", dog = " + dog + "}";
    }
}
