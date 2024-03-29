package com.example.demo.beans;

import com.example.demo.beans.MyFirstClass;
import org.springframework.context.annotation.Bean;

//@Configuration
//@Service
public class ApplicationConfig {
    //Consider marking one of the beans as @Primary,
    // updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed


    @Bean
    public MyFirstClass myFirstBean(){
        System.out.println("\nmyFirstBean scanned");
        return new MyFirstClass("first Bean");
    }

    @Bean
    public MyFirstClass mySecondBean(){
        System.out.println("\nmySecondBean scanned");
        return new MyFirstClass("second Bean");
    }
    @Bean
    //@Primary//will give higher priority and will execute before upper method/
    public MyFirstClass myThirdBean(){
        System.out.println("\nmyThirdBean scanned");
        return new MyFirstClass("Third Bean");
    }
}
