package com.reflection.annotation.io;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class DataContainer {
    private int intValue;
    private String stringValue;
    private boolean booleanValue;
}
