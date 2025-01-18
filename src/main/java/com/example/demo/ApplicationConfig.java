package com.example.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    public MyfirstClass myfirstClass() {
        return new MyfirstClass("first bean");
    }
    @Bean
    public MyfirstClass mySecondClass() {
        return new MyfirstClass("second bean");
    }
    @Bean
    public MyfirstClass myThirdClass() {
        return new MyfirstClass("Third bean");
    }

}
