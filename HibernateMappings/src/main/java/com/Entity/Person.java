package com.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String name;
	private String location;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private List<Orders> orders;

	public Person(String name, String location, List<Orders> orders) {
		super();
		this.name = name;
		this.location = location;
		this.orders = orders;
	}

	public Person(List<Orders> orders) {
		super();
		this.orders = orders;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", location=" + location + "]";
	}

}
