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
    public class UserService {
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


In this example, UserService is annotated with @Component. Since no explicit name is provided,
Spring automatically assigns the default bean name userService to this bean.



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


