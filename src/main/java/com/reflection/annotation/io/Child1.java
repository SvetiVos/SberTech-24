package com.reflection.annotation.io;

import lombok.NonNull;

class Child1 extends Task4And5And6{
    @Task2(hour = 1, priority = 2, description = "Child1")
    public void method1(@NonNull DataContainer dataContainer){
        dataContainer.setStringValue("Name1");
        dataContainer.setIntValue(5);
        dataContainer.setBooleanValue(true);
    }
    @Task2(hour = 5, priority = 1, description = "Child_1")
    public void method2(@NonNull DataContainer dataContainer){
        dataContainer.setStringValue("Name_1");
        dataContainer.setIntValue(5);
        dataContainer.setBooleanValue(true);
    }
}
