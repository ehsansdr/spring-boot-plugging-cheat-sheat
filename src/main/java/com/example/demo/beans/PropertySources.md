# @value and @PropertySources


spring just scan the application.properties or application.yml 
if your targe variable does not exist  spring will send exception

for scanning another file and allow spring to inject their variable you should have
in the class level
use :

    @PropertySource("classpath:(file name).prperties")   // no spaces allowed

    @PropertySource("classpath:foo.properties") // ok
    @PropertySource("classpath: foo.properties") // not ok beacuse of space


    @Configuration
    @PropertySource("classpath:foo.properties")
    public class PropertiesWithJavaConfig {
        //...
    }

## Defining Multiple Property Locations
The @PropertySource annotation is repeatable according to Java 8 conventions. Therefore, if we’re using Java 8 or higher, we can use this annotation to define multiple property locations:

    @PropertySource("classpath:foo.properties")
    @PropertySource("classpath:bar.properties")
    public class PropertiesWithJavaConfig {
        //...
    }


Of course, we can also use the @PropertySources annotation and specify an array of @PropertySource. 
This works in any supported Java version, not just in Java 8 or higher:

    @PropertySources({
            @PropertySource("classpath:foo.properties"),
            @PropertySource("classpath:bar.properties")
    })
    public class PropertiesWithJavaConfig {
        //...
    }


### **be carefull:**
**In either case, it’s worth noting that in the event of a property name collision, 
the last source read takes precedence.**



in this case if you just put the string without **`${}`** the string will
will put the value in the string

    @Value("my.prop")       
    private String myProp; 

output:
    
    my.prop


but in this case the program will find the variable which
is the same name in {} in 
.properties file in resources file
spring just scan the application.properties and if this
variable does not exist sent exception
for scanning another file you should have
in the class level


    @Value("${my.prop}")   
    private String myProp2;

output will be the value that ix in the variable in scanned property sources the will be scanned by 
spring


## application.properties: the Default Property File
Boot applies its typical convention over configuration approach to property files. 
This means that we can simply put an **`application.properties`** file in our **`src/main/resources`** directory, 
and it will be auto-detected. We can then inject any loaded properties from it as normal.

**`application.properties`** will be scanned even if you do not want it**

So, by using this default file, we don’t have to explicitly register a PropertySource or even provide a path to a property file.
    


## Using in Test

### we don’t want to use a file, we can specify names and values directly:

you can create property file not exactly 
,but you can use it for testing and this is continent

    @SpringBootTest(
    properties = {"foo=bar"})
    class MyFirstServiceTest {
    
        @Value("${foo}")
        private String foo;
    
        @Test
        public void ff(){
            System.out.println(foo);
        }
    }

output:
bar


for multi varable :

    @SpringBootTest(
    properties = {"foo=bar","ggg=jjjjjjjj"})
    class MyFirstServiceTest {
    
        @Value("${ggg}")
        private String foo;
    
        @Test
        public void ff(){
            System.out.println(foo);
        }
    }

output:
jjjjjjjj

### we don’t want to specify names and values directly use a file, we can use a file:
 but not like the same before 

instead of using 

    @PropertySource("classpath:(.prperties file name)")
use :

    @TestPropertySource("/(.prperties file name)") // no space


example:

    @SpringBootTest
    @TestPropertySource("/hhh.properties")
    class MyFirstServiceTest {
    
        @Value("${ddsasd}")
        private String foo;
    
        @Test
        public void ff(){
            System.out.println(foo); // out is 4444 like the varibal in hhh.properties ddsasd = 4444
        }
    }

4.10. Randomization of Property Values
If we don’t want determinist property values, we can use RandomValuePropertySource to randomize the values of properties:

    random.number=${random.int}
    random.long=${random.long}
    random.uuid=${random.uuid}

or:

    @Value("${random.uuid}")
    String url;
    @Value("${random.uuid}")
    String ddd;
    @Value("${random.uuid}")
    String password;

or:

    @Value("${random.long}")
    long url;
    @Value("${random.int}")
    int ddd;
    @Value("${random.uuid}")
    String password;


(https://www.baeldung.com/properties-with-spring#:~:text=The%20%40PropertySource%20annotation%20is%20repeatable,PropertySource(%22classpath%3Abar.)