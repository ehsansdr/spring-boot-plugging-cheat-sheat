the method in test class should :          
* be public            
* be void            
* annotated with @Test             
* without parameter
* the formant of naming should be in snake void_method_one and the name should express
the purpose of the method

*****************
## default method

* ### @BeforeEach :             
is used to signal that the annotated method should be executed before each @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, and @TestTemplate method in the current test class

* ### @AfterEach :      
is used to signal that the annotated method should be executed after each @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, and @TestTemplate method in the current test class.

* ### @BeforeAll :
is used to signal that the annotated method should be executed before all tests in the current test class.

* ### @AfterAll :          
is used to signal that the annotated method should be executed after all tests in the current test class.
*****************
In contrast to @AfterEach methods, @AfterAll methods are only executed once for a given test class.
In contrast to @BeforeEach methods, @BeforeAll methods are only executed once for a given test class.
if you press Alt + Insert you see menu to code better and default method