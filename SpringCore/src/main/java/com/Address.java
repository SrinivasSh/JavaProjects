package com;

public class Address {

	private int streetNo;
	private String streetName;
	private String landMark;

	private Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Address(int streetNo, String streetName, String landMark) {
		super();
		this.streetNo = streetNo;
		this.streetName = streetName;
		this.landMark = landMark;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", streetName=" + streetName + ", landMark=" + landMark + "]";
	}

}
