package com.example.demo.beans;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
@NoArgsConstructor
@Service
//@PropertySource("classpath:custome.properties")     // by this class we can tell spring scan
//                                                    // custome.properties file too
//                                                    // no space in the ()

@PropertySources({
        @PropertySource("classpath:custome.properties"),
        @PropertySource("classpath:hhh.properties"),
})
public class MyFirstService {
//    @Autowired
//    @Qualifier("bean2")
    private MyFirstClass myFirstClass;

    @Value("my.prop")       // in this case if you just put the string without ${} the string will
    private String myProp;  // will put the value in the string

    @Value("${my.prop}")    // but in this case the program will find the variable which
    private String myProp2; // is the same name in {} in .properties file in resources file
                            // spring just scan the application.properties and if this
                            // variable does not exist sent exception
                            // for scanning another file you should have
                            // in the class level



    @Value("${ddsasd}")     // spring is able to convert type int or string
    private int hhh;        // but remember that not string cast int

    private Environment environment; // from spring not hibernate


    /** be careful about naming ,name the class name as kamel case
                                        instead you get error in log */
//    @Autowired
//    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass2) {
//        this.myFirstClass = myFirstClass2;
//    }

//    @Autowired
//    public void injectDependencis(
//            @Qualifier("bean1") MyFirstClass myFirstClass
//    ){
//        System.out.println("injectDependencis");
//        this.myFirstClass = myFirstClass;
//    }

    @Autowired
    public void setMyFirstClass(@Qualifier("3th") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion(){
        return
                myProp + "\n\n" + myProp2 + "\n\n" + hhh;


                // for getting the java version that we use on this projects
                //environment.getProperty("java.version") + "\n\n" +

                // for getting the os of the system that we run from
                //environment.getProperty("os.name") + "\n\n" +

                // in resources in application.yml
                // paste like this   my.custom.properties : "alllllliiiii"
                // or application.properties : my.custom.properties = "alllllliiiii"
                //environment.getProperty("my.custom.properties")

    }
    public String tellStory(){
        return "\nthe dependency is saying : " + myFirstClass.sayHello();
    }

}
