package com.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {

		List<Vehicle> vehicle = new ArrayList<Vehicle>();

		vehicle.add(new Vehicle(78, "Car", "Mahindra Ev's", true));
		vehicle.add(new Vehicle(58, "Bike", "Royal Enfield", false));
		vehicle.add(new Vehicle(25, "Bus", "Mahindra", true));
		vehicle.add(new Vehicle(9, "Lorry", "Ashok Layland", false));
		vehicle.add(new Vehicle(67, "Train", "Vande Bharath", true));

		//// Using Anonymous Inner Class

		Comparator<Vehicle> comp = new Comparator<Vehicle>() {

			@Override
			public int compare(Vehicle veh1, Vehicle veh2) {

				return veh1.getBrand().compareTo(veh2.getBrand());
			}

		};

		/// Using Lamda Expression

		Comparator<Vehicle> compVeh = (v1, v2) -> {
			return Integer.compare(v1.getNo(), v2.getNo());
		};

		Collections.sort(vehicle, compVeh);
		System.out.println("------Using Lamda Expressions--------");
		for (Vehicle veh : vehicle) {
			System.out.println(veh);
		}

		Collections.sort(vehicle, new Vehicle());

		System.out.println("------Using normal comparator interface--------");
		for (Vehicle veh : vehicle) {
			System.out.println(veh);
		}

		Collections.sort(vehicle, comp);

		System.out.println("------Using annonymous Inner Class--------");
		for (Vehicle veh : vehicle) {
			System.out.println(veh);
		}

	}
}
