package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String company;
	private String location;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Employee(String empName, String company, String location) {
		super();
		this.empName = empName;
		this.company = company;
		this.location = location;
	}




	public Employee(int empId, String empName, String company, String location) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.company = company;
		this.location = location;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", company=" + company + ", location=" + location
				+ "]";
	}
	
	
	
	

}
