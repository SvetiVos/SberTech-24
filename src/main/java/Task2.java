import java.lang.annotation.*;

@Repeatable(Annotation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Task2 {
    int hour();
    int priority();
    String description();
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Annotation {
    Task2[] value();
}