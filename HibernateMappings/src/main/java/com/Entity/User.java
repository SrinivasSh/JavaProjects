package com.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "passport_number")
	private Passport passport;

	public User(String name) {
		super();
		this.name = name;
	}

	public User() {
		super();
	}

	public User(String name, Passport passport) {
		super();
		this.name = name;
		this.passport = passport;
	}
	

	public User(int userId, String name, Passport passport) {
		super();
		this.userId = userId;
		this.name = name;
		this.passport = passport;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name +"]";
	}


	

}
