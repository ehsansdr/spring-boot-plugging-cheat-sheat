package com.example.demo.Anotation;

import java.lang.annotation.*;

// https://www.geeksforgeeks.org/annotations-in-java/
@Target(ElementType.TYPE) /** if you do not have this yoy can use that everywhere*/
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(MyRepeatedAnnos.class)
public @interface VeryImportant {

//    ANNOTATION_TYPE	| Another annotation
//    CONSTRUCTOR	    | Constructor
//    FIELD	            | Field
//    LOCAL_VARIABLE	| Local variable
//    METHOD	        | Method
//    PACKAGE	        | Package
//    PARAMETER	        | Parameter
//    TYPE	            | Class, Interface, or enumeration

//    RUNTIME: These will be retained at runtime.
//    CLASS: Annotations will be retained at compile-time and ignored by the JVM.
//    SOURCE: Annotations will be retained at the source level and ignored by the compiler.
}
