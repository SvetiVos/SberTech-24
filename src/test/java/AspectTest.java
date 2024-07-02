package com.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(JavaConfig.class)
@SpringBootTest
public class AspectTest {

    @Autowired
    private Example example;

    @Test
    void parameterIsNull() {
        assertThrows(IllegalArgumentException.class, () -> example.doSomething("test", null));
    }

    @Test
    void parameterIsEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> example.doSomething("", Collections.emptyList()));
    }

    @Test
    void parametersAreValid() {
        example.doSomething("test", Arrays.asList("a"));
    }
}