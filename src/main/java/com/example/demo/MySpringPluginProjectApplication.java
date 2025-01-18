package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;


@SpringBootApplication
@RestController
public class MySpringPluginProjectApplication {
	public static void main(String[] args) throws SQLException {
		// SpringApplication.run(MySpringPluginProjectApplication.class, args);

		var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args);
		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		//System.out.println("myFirstService ======> " +  myFirstService.tellAStory() );
		System.out.println("java version ======> " +  myFirstService.getJavaVersion() );
		System.out.println("java version ======> " +  myFirstService.getOSName() );
		System.out.println("java version ======> " +  myFirstService.readprop() );
	}


}
