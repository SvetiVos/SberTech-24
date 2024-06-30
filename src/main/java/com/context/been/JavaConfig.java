package com.context.been;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    Parrot parrot1(){
        Parrot parrot = new Parrot();
        parrot.setParrotName("ююю");
        return new Parrot();
    }

    @Bean
    Parrot parrot2(){
        Parrot parrot = new Parrot();
        parrot.setParrotName("ыыы");
        return new Parrot();
    }

    @Bean
    Cat cat(){
        Cat cat = new Cat();
        cat.setCatName("ххх");
        return new Cat();
    }

    @Bean
    Dog dog(){
        Dog dog = new Dog();
        dog.setDogName("ццц");
        return new Dog();
    }

    @Bean
    public Person person(Parrot parrot1, Parrot parrot2, Cat cat, Dog dog){
        person(parrot1, parrot2, cat, dog).setPersonName("Рома");
        return new Person(parrot1, parrot2, cat, dog);
    }
}
