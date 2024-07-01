package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Aspect
@Component
public class NotEmptyAspect {

    @Before("")
    public void checkArguments(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                throw new IllegalArgumentException("Аргумент не должен быть null");
            } else if (args[i] instanceof String || args[i] instanceof Collection) {
                if (((String) args[i]).isEmpty() || ((Collection<?>) args[i]).isEmpty()) {
                    throw new IllegalArgumentException("Аргумент не должен быть пустым");
                }
            }
        }
    }
}
