package com.example.demo;

import com.example.demo.beans.MyFirstService;
import com.example.demo.beans.MyFirstClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class MySpringPluginProjectApplication {
	          // |this| |current|


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

		var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellStory());


//		MyFirstService myFirstService = ctx.getBean(MyFirstService.class); // the parameter class should be @Component in that
//		System.out.println(myFirstService.tellStory());

		/*
		and if you want to create object in bean form first have at least one @Component annotated class
		or another annotations that has the @Component in them like @Service and @Config
		then use getBean() for that

			MyFirstClass MyFirstClass = springObj.getBean(MyFirstClass.class);

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


}
