package com.example.demo;

import com.example.demo.Anotation.AnnoTesting;
import com.example.demo.Entity.Student;
import com.example.demo.Repostiory.SchoolRepository;
import com.example.demo.Repostiory.StudentRepository;
import com.example.demo.Service.mainPorfile.StudentMapper;
import com.example.demo.beans.MyFirstService;
import com.example.demo.beans.MyFirstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.time.LocalDateTime;

@SpringBootApplication
public class MySpringPluginProjectApplication {
	          // |this| |current|

	//@SuppressWarnings({"checked", "deprecation"})
	public static void main(String[] args) throws SQLException {

//		var app = new SpringApplication(MySpringPluginProjectApplication.class);
//		//app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
//		var ctx = app.run(args);


		// @SuppressWarnings({"checked", "deprecation"})
		AnnoTesting.newMethod();// if we have @SuppressWarnings("deprecation") we will not have warnings

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



//		MyFirstService myFirstClass = ctx.getBean(MyFirstService.class);
//		//System.out.println(myFirstClass.tellStory());
// 		System.out.println("\n\n" + myFirstClass.getJavaVersion());

//		ConfigProp configProp = ctx.getBean(ConfigProp.class);
//		configProp.ConfigPropLog();



//		MyFirstService myFirstClass = ctx.getBean(MyFirstService.class); // the parameter class should be @Component in that
//		System.out.println(myFirstClass.tellStory());

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


		//MyFirstService myFirstClass = springObj.getBean(MyFirstService.class);
		//System.out.println(myFirstClass.tellAStory());
		//System.out.println(myFirstClass.readProperties());

		/** if you are doing this way and do not have @component you will get Exception*/
	}


	// it execute without calling it
//	@Bean // if you need somthing useful at application start up CommandLineRunner will be useful
//	public CommandLineRunner commandLineRunner (
//			StudentRepository studentRepository // because od bean this executes and auto wired
//	){
//		return args -> {
//			var student = Student.builder()
//					.firstName("akbar ali")
//					.lastName("mamaly")
//					.emailId(StudentMapper.randomString(6) + "@gmail.com")
////					.timeCreated(LocalDateTime.now())
//					.build();
//			studentRepository.save(student);
//		};
//	}

}
