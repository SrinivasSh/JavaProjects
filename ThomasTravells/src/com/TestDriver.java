package com;

import java.util.ArrayList;

public class TestDriver {

	public static void main(String[] args) {

		Driver driver1 = new Driver(1, "Suhas", "Car", 748.21);
		Driver driver2 = new Driver(2, "Alice", "Car", 350.5);
		Driver driver3 = new Driver(3, "Bob", "Auto", 420.75);
		Driver driver4 = new Driver(4, "Charlie", "Lorry", 390.2);
		Driver driver5 = new Driver(5, "Buruto", "Auto", 555.21);
		Driver driver6 = new Driver(6, "Chandar", "Car", 755.21);
		Driver driver7 = new Driver(7, "Rahul", "Lorry", 255.21);
		Driver driver8 = new Driver(8, "Kamal", "Auto", 955.21);

		ArrayList<Driver> drivers = new ArrayList<Driver>();
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		drivers.add(driver4);
		drivers.add(driver5);
		drivers.add(driver6);
		drivers.add(driver7);
		drivers.add(driver8);

		Travel travel = new Travel();

		// Check the driver category
		boolean isCarDriver = travel.isCarDriver(driver6);
		System.out.println("Check if it Is a Car driver :" + isCarDriver);

		// Retrive by id
		String retriveById = travel.retriveByDriverId(drivers, 1);
		System.out.println("Retrive driver by driver id:" + retriveById);

		// Retrieve count of drivers
		int countOfDrivers = travel.retrieveCountOfDriver(drivers, "Lorry");
		System.out.println("Count no of drivers belong to tht category:" + countOfDrivers);

		// Retrieve by driver Category
		ArrayList<Driver> driverList = travel.retrieveDriver(drivers, "Car");
		for (Driver drive : driverList)
			System.out.println("Retrive the list of drivers belongs to the driver category:" + drive);

		// Maximum distance Covered by driver
		Driver driverMax = travel.retriveMaximumDistanceTravelledDriver(drivers);
		System.out.println("Max distance traveld by driver:" + driverMax);

		// Minimum Distance covered by driver
		Driver minDistance = travel.minimumDistanceCovered(drivers);
		System.out.println("Minimum distance travelled by Driver:" + minDistance);

		// Total distance covered by all Drivers
		int sumOfDistance = travel.sumOfAllDistanceCovered(drivers);
		System.out.println("Sum of distance travelled by all drivers in kms:" + sumOfDistance);

	}

}
