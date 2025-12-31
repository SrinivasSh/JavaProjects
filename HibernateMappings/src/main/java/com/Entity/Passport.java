package com.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	private int passportNo;
	private String issuedLocation;

	@OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Passport(int passportNo, String issuedLocation) {
		super();
		this.passportNo = passportNo;
		this.issuedLocation = issuedLocation;
	}

	public Passport(String issuedLocation, User user) {
		this.issuedLocation = issuedLocation;
		this.user = user;
	}

	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}

	public String getIssuedLocation() {
		return issuedLocation;
	}

	public void setIssuedLocation(String issuedLocation) {
		this.issuedLocation = issuedLocation;
	}

	@Override
	public String toString() {
		return "Passport [passportNo=" + passportNo + ", issuedLocation=" + issuedLocation + ", user=" + user + "]";
	}

	

}
