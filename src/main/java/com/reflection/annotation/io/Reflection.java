package com.reflection.annotation.io;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reflection{
    String string = "";
    LogCreator logCreator = new LogCreator();

    public List<Class> init(List<Class> newClass){
        newClass.add(Child1.class);
        newClass.add(Child2.class);
        return newClass;
    }

    public List<Class> search(List<Class> newClass, int days) {
        newClass = newClass.stream().filter(x -> ((Task1)x.getAnnotation(Task1.class)).days() == days).collect(Collectors.toList());
        return newClass;
    }

    public String create(List<Class> newClass, int hour, DataContainer dataContainer) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        for(Class c :newClass){
            List<Method> method = List.of(c.getDeclaredMethods());
            Object s = c.newInstance();
            method = method.stream().filter(x -> ((Task2)x.getAnnotation(Task2.class)).hour()==hour).collect(Collectors.toList());
            method = method.stream().sorted(Comparator.comparingInt(x -> ((Task2)x.getAnnotation(Task2.class)).priority())).toList();
            for(Method m: method){
                m.invoke(s, dataContainer);
                System.out.println(dataContainer.toString());
                string = string + dataContainer.toString() + '\n';
            }
        }
        return string;
    }

    public void reflect(int days, int hour, DataContainer dataContainer) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        List<Class> ch = new ArrayList<>();
        init(ch);
        ch = search(ch, days);
        create(ch, hour, dataContainer);
        logCreator.writeFile(string);
    }
}