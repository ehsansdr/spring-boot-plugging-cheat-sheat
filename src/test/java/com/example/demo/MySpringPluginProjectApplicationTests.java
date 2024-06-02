package com.example.demo;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest /** you can omit this if you do not want to test spring issues */
class MySpringPluginProjectApplicationTests {
	@Test
	public void testingMethod(){
		assertEquals(2,2);
	}


	/** will execute after all test method once
	 * if you press the class run button */
	@AfterAll
	static void afterAll() {
		System.out.println("inside the AfterAll method");
	}

	/** will execute before all test method once
	 * if you press the class run button */
	@BeforeAll
	static void beforeAll() {
		System.out.println("inside the beforeAll method");
	}

	/** will execute before each test method not once ,per each test method
	 * if you press the class run button */
	@BeforeEach
	void setUp() { // press alt + insert and press test method to have this method
		System.out.println("inside the BeforeEach method");
	}


	/** will execute before each test method not once , pre each method it will execute
	 * if you press the class run button */
	@AfterEach
	void tearDown() { // press alt + insert and press tear down method to have this method
		System.out.println("inside the AfterEach method");
	}

	@Test
	void contextLoads() {
	}

}
