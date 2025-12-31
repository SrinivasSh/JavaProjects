package com;


public interface FunctionalInterfaces {    ///Having one abstract method is called Functional Interface
	
	public void sayHi();
	
	
	default void Hello() {
		System.out.println("Hello from Parent FunctionalInterfaces ");
	}
	
	
	static void statMethod() {
		System.out.println("Static Method from Functional interface");
	}

}
