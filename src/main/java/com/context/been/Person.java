package com.context.been;

import lombok.*;

@Data
public class Person {
    private String personName;
    private final Parrot parrot1;
    private final Parrot parrot2;
    private final Cat cat;
    private final Dog dog;


    public Person(Parrot parrot1, Parrot parrot2, Cat cat, Dog dog) {
        this.parrot1 = parrot1;
        this.parrot2 = parrot2;
        this.cat = cat;
        this.dog = dog;

    }
}
