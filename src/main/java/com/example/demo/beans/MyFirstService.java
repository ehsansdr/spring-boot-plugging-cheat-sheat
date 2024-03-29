package com.example.demo.beans;


import com.example.demo.beans.MyFirstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//@Service
//@PropertySource("classpath:custome.properties")
@PropertySources({
        @PropertySource("classpath:custome.properties"),
        @PropertySource("classpath:hhh.properties")
})
public class MyFirstService {

    @Autowired
    @Qualifier("mySecondBean")//use @Bean method name or its @Qualifier(""), not its method's name
    private MyFirstClass myFirstClass;
    @Value("${custome.peoperty22}")
    String ff;

    @Value("${my.custome.properties}")
    String ff2;

    //private Environment environment;

    public String tellAStory(){
        return "the dependency is saying : " + myFirstClass.sayHello();
    }
    public String getJavaVersion(){
        return "\n\nenvironment.getProperty(java.version)";
    }
    public String readProperties(){
        return ff2;
    }


//    @Autowired
//    public void setEnvironment(@Qualifier Environment environment){
//        this.environment = environment;
//    }



}
