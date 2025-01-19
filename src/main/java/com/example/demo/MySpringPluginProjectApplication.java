package com.example.demo;

import com.example.demo.beans.MyFirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Collections;


@SpringBootApplication
@RestController
public class MySpringPluginProjectApplication {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(MySpringPluginProjectApplication.class, args);

		// defining profile by code
//		var app = new SpringApplication(MySpringPluginProjectApplication.class);
//		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "dev"));
//		var ctx = app.run(args);

		// bean creating
		// var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args);
//		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
//		System.out.println("MyFirstService: " + myFirstService.tellAStory());
//		System.out.println("readenv :" + myFirstService.readenv());
//		System.out.println("server port : " + myFirstService.ServerPort());
//		System.out.println("fileSep : " + myFirstService.fileSep());
//		System.out.println("os arc : " + myFirstService.osArch());
//		System.out.println("os version : " + myFirstService.osVersion());
		//System.getProperties().forEach((k, v) -> LOG.info("{} -> {}", k, v));
	}
}