package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private MyfirstClass myFirstClass;
    private Environment environment;

    // @Autowired // if we do not inject by the annotation spring will inject any thing
    // injectable
    public MyFirstService(@Qualifier("myfirstClass") MyfirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "the dependency is saying : " + myFirstClass.getMyVar();
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }
    public String getOSName(){
        return environment.getProperty("os.name");
    }
    public String readprop(){
        return environment.getProperty("mv.custome.properties");
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
