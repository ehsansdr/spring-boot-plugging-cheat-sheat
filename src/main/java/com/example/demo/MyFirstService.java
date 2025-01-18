package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private MyfirstClass myFirstClass;

    // @Autowired // if we do not inject by the annotation spring will inject any thing
    // injectable
    public MyFirstService(@Qualifier("myfirstClass") MyfirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying : " + myFirstClass.getMyVar();
    }
}
