package com.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name="allStudents", query="from Student"),@NamedQuery(name="selectedStudent",query="from Student where rollNo=?1")
			,@NamedQuery(name="updateStudent", query="update Student set name=?1 where rollNo=?2"),
			@NamedQuery(name="deleteStudent", query="delete Student where rollNo=?1")})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo;
	private String name;
	private String address;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int rollNo, String name, String address) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
	}

	public Student(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", address=" + address + "]";
	}

}
