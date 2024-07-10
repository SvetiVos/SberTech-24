package com.context.been;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public Parrot parrot1(){
        return new Parrot("ююю");
    }

    @Bean
    public Parrot parrot2(){
        return new Parrot("ыыы");
    }

    @Bean
    public Cat cat(){
        return new Cat("Мур");
    }

    @Bean
    public Dog dog(){
        return new Dog("ццц");
    }

    @Bean
    public Person person(Parrot parrot1, Parrot parrot2, Cat cat, Dog dog){
        return new Person(parrot1, parrot2, cat, dog);
    }
}
