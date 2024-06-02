package com.example.demo.beans;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component          // so automatically spring will consider this class as spring bean
public class MyFirstClass {
    private String myVar;

    /** if you have non default constructor in the class of type of bean you should add NoArgsConstructor instead you get error in log*/
    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "\nhello from myFirstClass ==> myVar = " + myVar ;
    }



//    @Bean       /** without @Component this will not work */
//    public MyFirstClass myFirstClass(){
//        return new MyFirstClass();
//    }
}
