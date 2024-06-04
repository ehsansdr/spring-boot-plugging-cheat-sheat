package com.example.demo.beans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/hhh.properties")
class MyFirstServiceTest {

    @Value("${ddsasd}")
    private String foo;

    @Test
    public void ff(){
        System.out.println(foo);
    }
}