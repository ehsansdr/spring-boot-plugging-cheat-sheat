package com.example.demo.beans;


import org.springframework.stereotype.Component;

@Component
public class MyfirstClass {

	private String myVar;



	public MyfirstClass(String myVar) {
		this.myVar = myVar;
	}


	public MyfirstClass myfirstClass() {
		return new MyfirstClass("first bean");
	}


	public String sayHello() {
		return "hello from the MyfirstClass ====> myvar = " + myVar;
	}


	public String getMyVar() {
		return myVar;
	}
}
