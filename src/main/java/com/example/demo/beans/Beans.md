# beans hint 
for having better use of java object bean create better type of object for use

*******
for create bean or using bean annotation it is senseless to have @Component or the annotations which has
@Component in it
@Component is an annotation that allows Spring to automatically detect the custom beans.
like: @Configuration  , @Service 

for getting bean from the class that will be scanned as component you should get the object of
spring in main method of the project for getting bean:

    var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args);

and you can get bean of component class be **getBean()**;
    
    MyFirstClass myFirstClass = ctx.getBean((class which has @Component and same as refrenc).class);

so you create default bean!! 
              
[https://www.geeksforgeeks.org/how-to-create-a-spring-bean-in-3-different-ways/]()

if you want to create your own bean you can use @Bean in @Component class like this:
        
    @Component          // so automatically spring will consider this class as spring bean
    public class MyFirstClass {
        @Bean       /** without @Component this will not work */
        public MyFirstClass myFirstClass(){
            return new MyFirstClass();
        }
    }

for creating bean of this class(MyFirstClass) you can code this method with this return type 
in another class which need to have @Component in that
    
    @Configuration
    public class ApplicationConfig {

        @Bean 
        public MyFirstClass myFirstClass(){
            return new MyFirstClass();
        }

    }

so if you get bean from the MyFirstClass object and MyFirstClass class does not have  @bean method 
it still works and get the MyFirstClass bean which created in another class

********
		
### bean naming 

[https://www.javacodegeeks.com/spring-bean-naming.html](https://www.javacodegeeks.com/spring-bean-naming.html)

In the Spring framework, each bean must possess a name 
that is unique within its containing ApplicationContext
However, if we don’t explicitly specify a name for the bean, 
Spring generates a default name based on the class name with a lowercase initial letter.

When we annotate a class with @Component without specifying a name,
Spring automatically generates a bean name using the following strategy:

It takes the class name.
It converts the first character of the class name to lowercase.
This lowercase name becomes the default bean name.


    import org.springframework.stereotype.Component;
    
    @Component
    public class MyFirstClass {
        // Class Implementation
    }
    ******
    var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args); 
    MyFirstClass myFirstClass = ctx.getBean("myFirstClass",MyFirstClass.class);	// ok
    System.out.println(myFirstClass.sayHello());
    ******
    var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args); 
    MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);	// ok
    System.out.println(myFirstClass.sayHello());
    ******
    var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args); 
    MyFirstClass myFirstClass = ctx.getBean("MyFirstClass",MyFirstClass.class);	// not ok
    System.out.println(myFirstClass.sayHello());


In this example, MyFirstClass is annotated with @Component. Since no explicit name is provided,
Spring automatically assigns the default bean name myFirstClass to this bean.



n Spring Framework, when we use Java **configuration** to define beans,
we often use the @Bean annotation to explicitly declare a bean. Similar to @Component,
each bean in the Spring container must have a unique name within the ApplicationContext. If we don’t provide a name explicitly,
Spring generates a default name for the bean.


When we declare a bean using the @Bean annotation without specifying a name,
Spring generates a bean name based on the method name by default.

he name of the bean is the same as the name of the method annotated with @Bean.


    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    public class AppConfig {
    
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

In this example, the **userService()** method is annotated with @Bean within the AppConfig class. 
Since no explicit name is provided,
Spring automatically assigns the default bean name userService to this bean.




In Spring Framework, when defining beans using annotations such as @Component or @Bean, 
or through XML configuration, it’s often necessary to provide explicit names to beans.
Explicitly naming beans helps in better understanding and managing the application context.

Both @Component and @Bean annotations support specifying a name for the bean using the value attribute. 
For example, to explicitly name a bean using @Component:

    import org.springframework.stereotype.Component;
    
    @Component("customName")
    public class MyComponent {
        // Class implementation
    }

And with @Bean:

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    public class AppConfig {
    
        @Bean("customName")
        public MyBean myBean() {
            return new MyBean();
        }
    } 

In both cases, the bean will be registered with the name **customName** in the application context.


you can name one bean to multiple naming
    
    @Bean(name = {
        "akbar",
        "ali",
        "mmd"
    })        // for using the @Bean naming have no arg constructor in the bean class
    public MyFirstClass myFirstClass2(){
        //System.out.println("\nApplicationConfig.class myFirstClass2();");
        return new MyFirstClass("second bean");
    }


### Qualifier

    @Bean        // for using the @Bean naming have no arg constructor in the bean class
    @Qualifier("bean1")
    public MyFirstClass myFirstClass(){
    //System.out.println("\nApplicationConfig.class myFirstClass();");
    return new MyFirstClass("First bean");
    }

    @Bean       // for using the @Bean naming have no arg constructor in the bean class
    @Qualifier("bean2")
    public MyFirstClass myFirstClass2(){
        //System.out.println("\nApplicationConfig.class myFirstClass2();");
		return new MyFirstClass("second bean");
	}

    ********
    
    @Autowired
    @Qualifier("bean2")   // use the exact same name that you gave to the method
    private MyFirstClass myFirstClass;

    or 

    @Autowired
    public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass2) {
        this.myFirstClass = myFirstClass2;
    }


    @Autowired
    @Qualifier("bean2")
    private MyFirstClass myFirstClass;

or of you did not have @Qualifier with specific name you can get aor autowired that by the bean name
the method name or the @Bean(name) like:

    @Bean       // for using the @Bean naming have no arg constructor in the bean class
    public MyFirstClass myFirstClass2(){
        //System.out.println("\nApplicationConfig.class myFirstClass2();");
        return new MyFirstClass("second bean");
    }

    *****
        
    @Autowired
    @Qualifier("myFirstClass2")
    private MyFirstClass myFirstClass;


we can name or qualify the bean by @Qualifier :

    @Bean        // for using the @Bean naming have no arg constructor in the bean class
    @Qualifier("bean1")
    public MyFirstClass myFirstClass(){
        //System.out.println("\nApplicationConfig.class myFirstClass();");
        return new MyFirstClass("First bean");
    }

    *****

    @Bean("3th")        // for using the @Bean naming have no arg constructor in the bean class
    @Qualifier("bean3")
    public MyFirstClass myFirstClass(){
        //System.out.println("\nApplicationConfig.class myFirstClass();");
        return new MyFirstClass("3th bean");
    }

    ******
you can get the @bean by the bean name or @Qualifier name


    @Qualifier("3th") MyFirstClass myFirstClass
or
    
    @Qualifier("bean3") MyFirstClass myFirstClass

**IMPORTANT HINT :

@Autowired annotated method will execute even if they are not called so if you have 
@Autowired annotated method it will execute anyway**


## bean profile:
you can have bean just in specefic profile by using **`@Profile`**

but you should obey some important role:    

**1. you should have qualifier or any other annotation for Autowire them which make order like  @Primary or @Qualifier or bean name:
if not the spring can not find that even if there is only one existing bean**   
**2.if one bean were not been annotated by @Profile that will accessible in all profiles**
example :

    @Bean        
    @Profile("dev")
    @Primary            // we make priority for this
    public MyFirstClass myFirstClass(){
    System.out.println("ApplicationConfig.class myFirstClass();");
    return new MyFirstClass("First bean");
    }


    @Bean       
    @Qualifier("bean2")  // we qualified this
    @Profile("test") 
    //@Primary
    public MyFirstClass myFirstClass2(){
        System.out.println("ApplicationConfig.class myFirstClass2();");
		return new MyFirstClass("second bean");
	}

    @Bean("3th")       // we name this 
    @Profile("3th")
    public MyFirstClass myFirstClass3(){
        System.out.println("MyFirstClass.class myFirstClass3();");
        return new MyFirstClass("3th bean");
    }
 
    // in anouther class we have these 3 cases:
    .........

    @Autowired              // dev profile
                            // we use @Primary to auto wire automaticlly
    private MyFirstClass myFirstClass;
    
    .........

    @Autowired              // test profile
    @Qualifier("bean2")     // we use the @Qualifier("bean2") passing argument
    private MyFirstClass myFirstClass;
    .........

    @Autowired              // 3th profile
    @Qualifier("3th")       // we use the @Bean(name)
    private MyFirstClass myFirstClass;
    
    
