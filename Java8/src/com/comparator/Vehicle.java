package com.comparator;

import java.util.Comparator;

public class Vehicle implements Comparator<Vehicle> {
	
	private int no;
	private String name;
	private String brand;
	private boolean electric;
	
	
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Vehicle(int no, String name, String brand, boolean electric) {
		super();
		this.no = no;
		this.name = name;
		this.brand = brand;
		this.electric = electric;
	}



	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public boolean isElectric() {
		return electric;
	}



	public void setElectric(boolean electric) {
		this.electric = electric;
	}



	@Override
	public String toString() {
		return "Vehicle [no=" + no + ", name=" + name + ", brand=" + brand + ", electric=" + electric + "]";
	}



	@Override
	public int compare(Vehicle v1, Vehicle v2) {
		
		return Integer.compare(v1.no, v2.no);
	}
	
	
	
	
	

}
