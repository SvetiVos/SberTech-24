package com.Context.Component;

import com.Context.Been.Cat;
import com.Context.Been.Dog;
import com.Context.Been.Parrot;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Person {
    @Autowired
    private final com.Context.Been.Parrot parrot1;
    @Autowired
    private final com.Context.Been.Parrot parrot2;
    @Autowired
    private final com.Context.Been.Cat cat;
    @Autowired
    private final com.Context.Been.Dog dog;


    public Person(com.Context.Been.Parrot parrot1, Parrot parrot2, Cat cat, Dog dog) {
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
