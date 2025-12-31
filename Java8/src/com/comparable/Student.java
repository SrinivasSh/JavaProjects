package com.comparable;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private String address;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}


	@Override
	public  int compareTo(Student student) {
		
		//return this.id==student.id ? 0 : this.id > student.id ? 1 : -1;
		
		return this.address.compareTo(student.address);
	}
	
	
	
	
	

}
