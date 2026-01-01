package com.jdbc;

public class Employee {

	private int empId;
	private String company;
	private String empName;
	private String location;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String company, String empName, String location) {
		super();
		this.empId = empId;
		this.company = company;
		this.empName = empName;
		this.location = location;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", company=" + company + ", empName=" + empName + ", location=" + location
				+ "]";
	}

}
