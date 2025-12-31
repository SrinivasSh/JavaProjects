package com.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@EmbeddedId
	private VehicleNo vehicleNo;
	private String vehicleType;
	private int cost;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String vehicleType, int cost) {
		super();
		this.vehicleType = vehicleType;
		this.cost = cost;
	}
	
	

	public Vehicle(VehicleNo vehicleNo, String vehicleType, int cost) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
		this.cost = cost;
	}
	
	

	public VehicleNo getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(VehicleNo vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", vehicleType=" + vehicleType + ", cost=" + cost + "]";
	}

}
