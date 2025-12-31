package com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	private int orderId;
	private String productName;

	@ManyToOne
	@JoinColumn(name = "personId")
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Orders(int orderId, String productName) {
		super();
		this.orderId = orderId;
		this.productName = productName;
	}

	public Orders(String productName, Person person) {
		super();
		this.productName = productName;
		this.person = person;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String productName) {
		super();
		this.productName = productName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", productName=" + productName + ", person=" + person + "]";
	}

}
