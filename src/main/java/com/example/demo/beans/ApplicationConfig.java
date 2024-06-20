package com.example.demo.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean        // for using the @Bean naming have no arg constructor in the bean class
    @Profile("dev")
    //@Qualifier("bean1")
    @Primary
    public MyFirstClass myFirstClass(){
        System.out.println("ApplicationConfig.class myFirstClass();");
        return new MyFirstClass("First bean");
    }


    @Bean       // for using the @Bean naming have no arg constructor in the bean class
    //@Qualifier("bean2")
    @Profile("test")
    @Primary
    public MyFirstClass myFirstClass2(){
        System.out.println("ApplicationConfig.class myFirstClass2();");
		return new MyFirstClass("second bean");
	}

    @Bean("3th")        // for using the @Bean naming have no arg constructor in the bean class
    @Profile("3th")
    @Primary
    public MyFirstClass myFirstClass3(){
        System.out.println("MyFirstClass.class myFirstClass3();");
        return new MyFirstClass("3th bean");
    }

}
