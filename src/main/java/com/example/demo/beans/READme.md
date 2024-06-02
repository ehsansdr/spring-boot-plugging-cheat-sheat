# beans hint 
for having better use of java object bean create better type of object for use

*******
for create bean or using bean annotation it is senseless to have @Component or the annotations which has
@Component in it like: @Configuration  , @Service 

for getting bean from the class that will be scanned as component you should get the object of
spring in main method of the project for getting bean:

    var ctx = SpringApplication.run(MySpringPluginProjectApplication.class, args);



		
