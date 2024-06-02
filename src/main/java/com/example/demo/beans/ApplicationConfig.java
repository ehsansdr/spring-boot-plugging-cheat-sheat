package com.example.demo.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean        // for using the @Bean naming have no arg constructor in the bean class
    @Primary
    public MyFirstClass myFirstClass3(){
        //System.out.println("\nApplicationConfig.class myFirstClass();");
        return new MyFirstClass("First bean");
    }

    @Bean//("2nd")        // for using the @Bean naming have no arg constructor in the bean class
	public MyFirstClass myFirstClass2(){
        //System.out.println("\nApplicationConfig.class myFirstClass2();");
		return new MyFirstClass("second bean");
	}

    @Bean//("3th")        // for using the @Bean naming have no arg constructor in the bean class
    public MyFirstClass myFirstClass(){
        //System.out.println("\nMyFirstClass.class myFirstClass3();");
        return new MyFirstClass("3th bean");
    }

}
