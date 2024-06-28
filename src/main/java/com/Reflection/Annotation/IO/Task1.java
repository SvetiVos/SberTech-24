package com.Reflection.Annotation.IO;
import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Task1 {

    int days();
}