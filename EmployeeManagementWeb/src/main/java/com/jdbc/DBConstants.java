package com.jdbc;

public class DBConstants {
	
	public static final String URL="jdbc:mysql://localhost:3306/employemanagementweb";
	public static final String USERNAME="root";
	public static final String PASSWORD="Srinivas@1998";
	public static final String INSERT_USER="insert into users values(?,?)";
	public static final String VALIDATE_USER="select * from users where email=?";
	public static final String GET_ALL_EMPLOYEES="select * from employee";
	public static final String SAVE_EMPLOYEE="insert into employee(name,age,email,phone_number,salary) values(?,?,?,?,?)";
	public static final String GET_EMPOLYEE="select * from employee where empId=?";
	public static final String UPDATE_EMPLOYEE="update employee set name=?, age=?,email=?,phone_number=?,salary=? where empId=?";
	public static final String DELETE_EMPLOYEE="delete from employee where empId=?";
}