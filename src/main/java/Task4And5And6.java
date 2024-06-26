import lombok.NonNull;


@Task1(days = 4)
abstract class Task4And5And6{
    abstract void method1(@NonNull DataContainer dataContainer);
    abstract void method2(@NonNull DataContainer dataContainer);
}

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


@Task1(days = 5)
class Child2 extends Task4And5And6{
    @Task2(hour = 6, priority = 1, description = "Child2")
    public void method1(@NonNull DataContainer dataContainer){
        dataContainer.setStringValue("Name_2");
        dataContainer.setIntValue(15);
        dataContainer.setBooleanValue(true);
    }
    @Task2(hour = 8, priority = 2, description = "Child_2")
    public void method2(@NonNull DataContainer dataContainer){
        dataContainer.setStringValue("Name_2");
        dataContainer.setIntValue(15);
        dataContainer.setBooleanValue(true);
    }
}