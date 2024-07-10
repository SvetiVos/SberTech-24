package com.context.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.*;

@Data
@Scope("prototype")
@Component
public class Parrot {
    private String parrotName = "Parrot";
}
