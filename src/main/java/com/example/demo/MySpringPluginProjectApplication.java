package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;

import static com.example.demo.ConstantClass.JJJJ;

@SpringBootApplication
@RestController
public class MySpringPluginProjectApplication {
	public static void main(String[] args) throws SQLException {
		/*
		var app = new SpringApplication(MySpringPluginProjectApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var springObj = app.run(args);
		*/

		/**$ docker run test some-postgres -e POSTGRES_PASSWORD=root -d postgres*/

		/*
		if you want to create bean (spring object) you should do that with using spring application
		so save spring returning in var like this
		*/

		SpringApplication.run(MySpringPluginProjectApplication.class, args);

		/*
		and if you want to create object in bean form first have at least one @Component annotated class
		or another annotations that has the @Component in them like @Service and @Config
		then use getBean() for that

			MyFirstClass myFirstClass = springObj.getBean(MyFirstClass.class);

		and you can use name for you bean
		but  be careful about some hints

		1. spring scan the annotated class so if you use @Component or any annotation that contains @Component
		will be scanned

		2.for name part you should set special string
		the name of @Bean method in @Component or has @component or
		@Bean("myBean") in annotation parameter string if you not you will get Exception
		*/


		//MyFirstService myFirstService = springObj.getBean(MyFirstService.class);
		//System.out.println(myFirstService.tellAStory());
		//System.out.println(myFirstService.readProperties());

		/**if you are doing this way and do not have @component you will get Exception*/
	}
//    spring:
//    datasource:
//    url: jdbc:postgresql://localhost:5332/sayHello
//    username: sdr
//    password: 1235
//    jpa:
//    hibernate:
//    ddl-auto: create-drop
//    properties:
//    hibernate:
//    dialect: org.hibernate.dialect.PostgreSQLDialect
//    format_sql: true
//    show-sql: true


//	@Bean
//	public Customer sayHello(){
//		return new Customer();
//	}


//	@GetMapping
//	public String helloWorld(){
//		System.out.println("\nffff");
//		return "dddf";
//	}

}
