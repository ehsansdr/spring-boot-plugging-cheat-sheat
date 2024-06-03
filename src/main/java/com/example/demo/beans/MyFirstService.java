package com.example.demo.beans;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@Service
public class MyFirstService {
//    @Autowired
//    @Qualifier("bean2")
    private MyFirstClass myFirstClass;

    @Autowired
    public void setMyFirstClass(@Qualifier("bean3") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    /** be careful about naming ,name the class name as kamel case
                                        instead you get error in log */
//    @Autowired
//    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass2) {
//        this.myFirstClass = myFirstClass2;
//    }

//    @Autowired
//    public void injectDependencis(
//            @Qualifier("bean1") MyFirstClass myFirstClass
//    ){
//        System.out.println("injectDependencis");
//        this.myFirstClass = myFirstClass;
//    }



    public String tellStory(){
        return "\nthe dependency is saying : " + myFirstClass.sayHello();
    }
}
