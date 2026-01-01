package com;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class Employee {

	private int id;
	private String name;

	private Map<String, String> skills;

	private Address address;

	private Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Employee(int id, String name, Map<String, String> skills, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
		this.address = address;
	}

	@PostConstruct
	public void getInit() {
		System.out.println("Pre Consctuctor method called!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getSkills() {
		return skills;
	}

	public void setSkills(Map<String, String> skills) {
		this.skills = skills;
	}

	public Address getAddress() {
		return address;
	}

	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", skills=" + skills + ", address=" + address + "]";
	}

}
