package com.example.demo.beans;

import org.springframework.stereotype.Component;


public class MyFirstClass {
 //ctrl + alt + o for removing unused import

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
       return "\n\n\nhello from the MyFirstClass ===> myVar = " + myVar;
    }

}
