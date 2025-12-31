package com;

public class VehicleTest {

	public static void main(String[] args) {

		Bike b = new Bike();
		b.start();
//		b.stop();

		//// USING ANNOYMOUS INNER CLASS IMPLEMENTATION

		Vehicle lorry = new Vehicle() {

			@Override
			public void start() {
				System.out.println("Lorry Started using anonymous inner class");

			}

//			@Override
//			public void stop() {
//				System.out.println("Lorry Stop");
//
//			}
//
//			@Override
//			public void drive() {
//				super.drive();
//				System.out.println("Driving from child class using anonymous inner class");
//			}

		};

		lorry.start();
//		lorry.stop();
//		lorry.drive();
		
		
		/////USING FUNCTIONAL INTERFACES IMPLEMENTATION
		
		Vehicle car= () -> {System.out.println("Started Car usinf fuctional interfaces");};
		
		car.start();
		

	}

}
