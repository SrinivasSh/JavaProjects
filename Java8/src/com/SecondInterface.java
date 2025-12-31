package com;


public interface SecondInterface {
	
	
	public void sayBye();
	
	
	default void Hello() {
		System.out.println("Hello from Parent SecondInterface ");
	}

	
	
	static void statMethod() {
		System.out.println("Static method from Second Interface");
	}
	
}