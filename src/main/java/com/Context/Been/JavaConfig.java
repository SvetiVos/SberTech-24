package com.Context.Been;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    Parrot parrot1(){
        Parrot parrot = new Parrot();
        return new Parrot();
    }

    @Bean
    Parrot parrot2(){
        Parrot parrot = new Parrot();
        return new Parrot();
    }

    @Bean
    Cat cat(){
        Cat cat = new Cat();
        return new Cat();
    }

    @Bean
    Dog dog(){
        Dog dog = new Dog();
        return new Dog();
    }

    @Bean
    public Person person(Parrot parrot1, Parrot parrot2, Cat cat, Dog dog){
        return new Person(parrot1, parrot2, cat, dog);
    }
}
