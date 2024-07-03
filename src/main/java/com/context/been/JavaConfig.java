package com.context.been;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public Parrot parrot1(){
        Parrot parrot = new Parrot();
        parrot.setParrotName("ююю");
        return new Parrot();
    }

    @Bean
    public Parrot parrot2(){
        Parrot parrot = new Parrot();
        parrot.setParrotName("ыыы");
        return new Parrot();
    }

    @Bean
    public Cat cat(){
        Cat cat = new Cat();
        cat.setCatName("Мур");
        return new Cat();
    }

    @Bean
    public Dog dog(){
        Dog dog = new Dog();
        dog.setDogName("ццц");
        return new Dog();
    }

    @Bean
    public Person person(Parrot parrot1, Parrot parrot2, Cat cat, Dog dog){
        return new Person(parrot1, parrot2, cat, dog);
    }
}
