package com.reflection.annotation.io;

import java.lang.annotation.*;

@Repeatable(Annotation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Task2 {
    int hour();
    int priority();
    String description();
}