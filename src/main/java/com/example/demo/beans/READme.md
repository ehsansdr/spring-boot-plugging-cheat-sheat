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
              
https://www.geeksforgeeks.org/how-to-create-a-spring-bean-in-3-different-ways/

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


		
