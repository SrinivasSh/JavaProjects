package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SignUp {
	
	public static void main(String[] args) throws SQLException {
		
		
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Valid userName:");
		String userName=sc.nextLine();
		
		System.out.println("Enter Valid password:");
		String password=sc.nextLine();
		
		JDBCUtil jdbcUtil=new JDBCUtil();
		Connection connection=jdbcUtil.getConnection();
		Statement stmt=connection.createStatement();
		
		String insert = "INSERT INTO userManagement VALUES ('" + userName + "', '" + password + "')";
		
		stmt.executeUpdate(insert);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
}
