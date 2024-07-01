package com.aspect;

import java.util.Collection;

public class Example {
    public void doSomething(@NotEmpty String string, @NotEmpty Collection<String> collection) {
        System.out.println("Метод выполняется с параметрами: " + string + ", " + collection);
    }

    public void doSomethingElse(String string, Collection<String> collection) {
        System.out.println("Метод выполняется с параметрами: " + string + ", " + collection);
    }
}