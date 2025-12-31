package com.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class VehicleNo {

	private int vehicleNo;
	private String engineNo;

	public VehicleNo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleNo(int vehicleNo, String engineNo) {
		super();
		this.vehicleNo = vehicleNo;
		this.engineNo = engineNo;
	}

	public int getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	@Override
	public String toString() {
		return "VechicleNo [vehicleNo=" + vehicleNo + ", engineNo=" + engineNo + "]";
	}
	
	

}
