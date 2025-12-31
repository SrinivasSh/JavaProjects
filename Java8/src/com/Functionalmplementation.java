package com;

public class Functionalmplementation implements FunctionalInterfaces, SecondInterface {

	@Override
	public void sayHi() {
		System.out.println("Method from FunctionalInterfaces Interface");

	}

	@Override
	public void sayBye() {
		System.out.println("Method from Second Interface");

	}

	@Override
	public void Hello() {

		SecondInterface.super.Hello();
		FunctionalInterfaces.super.Hello(); /// call FDefault methods from parent Interfaces

	}
	
	
//	public void statMethod() {
//		System.out.println("Static method from Child Class");    //cannnot be override in the child class
//	}

}
