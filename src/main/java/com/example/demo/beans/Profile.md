# Profile 

for creating profile make sure you follow this role to format
    
    application-(profile name).yml 
or
    
    application-(profile name).properties

like:
creating profile dev in yml:

    application-dev.yml  

and put it in this path :

    src/main/resources 

************
## how to activate profile 
 we have 3 ways for :

### 1. order in yml or properties:

in `application.yml` paste this:

    spring:
        profiles:
            active:
                - (profile name)

in `application.properties` paste this:

    spring.profile.active = (profile name),(profile name),(profile name),...

#### ba careful:
**1. if you put the uncreated profile spring will create that and will not send exception or stop programe**       
**2. be careful about order**

### 2.Programmatically Setting Profiles
You can programmatically set active profiles by calling 


    SpringApplication.setAdditionalProfiles()
before your application runs. 
It is also possible to activate profiles by using Spring’s ConfigurableEnvironment interface. 

**`setAdditionalProfiles("dev")`**

    var app = new SpringApplication(MySpringPluginProjectApplication.class);
    app.setAdditionalProfiles("(profile name)");
    var ctx = app.run(args);
 example:

activating "dev" profile:

    var app = new SpringApplication(MySpringPluginProjectApplication.class);
    app.setAdditionalProfiles("dev");
    var ctx = app.run(args);

be careful if you have this:
    
    var app = new SpringApplication(MySpringPluginProjectApplication.class);
		app.setAdditionalProfiles("gihiohnph");
		app.setAdditionalProfiles("dev");
		var ctx = app.run(args);


you can not activate 2 profile. you active last profile name (dev)



or you can use:

    var app = new SpringApplication(MySpringPluginProjectApplication.class);
	app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","(profile name)")); 
    var ctx = app.run(args);

example:

    var app = new SpringApplication(MySpringPluginProjectApplication.class);
	app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
    var ctx = app.run(args);


be careful :         

    var app = new SpringApplication(MySpringPluginProjectApplication.class);
    app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
    app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","ggg"));
    var ctx = app.run(args);

in this case you will not activate dev and ggg together. you just activate last profile name(ggg)





https://www.baeldung.com/spring-profiles      
https://docs.spring.io/spring-boot/reference/features/profiles.html       
https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features-profiles.html