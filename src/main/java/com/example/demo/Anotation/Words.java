package com.example.demo.Anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
public @interface Words {
    // Parameters will not have a null value but can have a default value.
    String word() default "hello";
    int value() default 0;
}
