package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

		SpringApplication.run(MySpringPluginProjectApplication.class, args);
	}


}
