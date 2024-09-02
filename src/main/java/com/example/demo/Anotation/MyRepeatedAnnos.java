package com.example.demo.Anotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyRepeatedAnnos {
    // have an array of the repeated class annotation in the class the you put in parameter of @Repeatable(MyRepeatedAnnos.class)
    Words[] value();
}
