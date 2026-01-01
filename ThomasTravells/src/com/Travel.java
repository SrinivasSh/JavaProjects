package com;

import java.util.ArrayList;

public class Travel {

	Driver driver; // Has a relationship

	//// isCarDriver()

	public boolean isCarDriver(Driver driver) {

		if (driver == null || driver.getCategory() == null) {
			return false;
		}
		return driver.getCategory().equalsIgnoreCase("Car");
	}

	// Retrive By Driver Id

	public String retriveByDriverId(ArrayList<Driver> drivers, int driverId) {

		for (Driver driver : drivers) {
			if (driver.getId() == driverId) {
				return "Driver name is " + driver.getName() + " Belonging to the category " + driver.getCategory()
						+ " traveled";
			}
		}
		return "Driver with ID " + driverId + " not found.";

	}

	// Retrive Count Of Driver

	public int retrieveCountOfDriver(ArrayList<Driver> drivers, String driverCategory) {
		int count = 0;
		for (Driver driver : drivers) {
			if (driver.getCategory().equalsIgnoreCase(driverCategory)) {
				count++;
			}
		}
		return count;

	}

	/// Retrieve Driver

	public ArrayList<Driver> retrieveDriver(ArrayList<Driver> drivers, String driverCategory) {

		ArrayList<Driver> matchedDrivers = new ArrayList<>();
		for (Driver driver : drivers) {
			if (driver.getCategory().equals(driverCategory)) {
				matchedDrivers.add(driver);
			}
		}

		return matchedDrivers;
	}

	// Retrive Maximum Distance Travelled Driver

	public Driver retriveMaximumDistanceTravelledDriver(ArrayList<Driver> drivers) {
		Driver maxDriver = drivers.get(0);
		for (Driver driver : drivers) {
			if (driver.getTotalDistance() > maxDriver.getTotalDistance()) {
				maxDriver = driver;
			}
		}
		return maxDriver;
	}

	// Retrieve Min Distance

	public Driver minimumDistanceCovered(ArrayList<Driver> drivers) {
		Driver minDriver = drivers.get(0);
		for (Driver min : drivers) {
			if (min.getTotalDistance() < minDriver.getTotalDistance()) {
				minDriver = min;
			}
		}

		return minDriver;

	}

	/// Sum of all distances
	public int sumOfAllDistanceCovered(ArrayList<Driver> drivers) {

		int sum = 0;
		for (Driver sumOfDistance : drivers) {
			sum += sumOfDistance.getTotalDistance();

		}
		return sum;

	}

//	public boolean isCarDriver(Driver driver) {
//		if (driver == null || driver.getCategory() == null) {
//	        return false;
//	    }
//	    return driver.getCategory().equalsIgnoreCase("Car");
//		
//	}
//	
//	public String retriveByDriverId(ArrayList<Driver> drivers,int driverId) {
//		for (Driver driver : drivers) {
//	        if (driver.getId()==driverId) {
//	            return "Driver name is " + driver.getName() +
//	                   " Belonging to the category " + driver.getCategory() +
//	                   " traveled";
//	        }
//	    }
//	    return "Driver with ID " + driverId + " not found.";
//	}
//		
//	
//	
//	public int retriveCountOfDriver(ArrayList<Driver> drivers, String driverCategory) {
//		int count = 0;
//	    for (Driver driver : drivers) {
//	        if (driver.getCategory().equalsIgnoreCase(driverCategory)) {
//	            count++;
//	        }
//	    }
//	    return count;
//	}
//	
//	public ArrayList<Driver> retriveDriver(ArrayList<Driver> drivers, String driverCategory) {
//		ArrayList<Driver> matchedDrivers = new ArrayList<>();
//		for(Driver driver: drivers) {
//			if(driver.getCategory().equals(driverCategory)) {
//				matchedDrivers.add(driver);
//			}
//		}
//		
//		return matchedDrivers;
//		
//	}
//	
//	public Driver retriveMaximumDistanceTravelledDriver(ArrayList<Driver> driver) {
//		if (driver == null || driver.isEmpty()) {
//	        return null; // or throw an exception depending on your needs
//	    }
//
//	    Driver maxDriver = driver.get(0);
//
//	    for (Driver arrDriver : driver) {
//	        if (arrDriver.getTotalDistance() > maxDriver.getTotalDistance()) {
//	            maxDriver = arrDriver;
//	        }
//	    }
//
//	    return maxDriver;
//	}

}
