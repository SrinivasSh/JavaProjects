package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		
		prepareStatement();
//
//		try {
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter Valid userName:");
//			String userName = sc.nextLine();
//
//			System.out.println("Enter Valid password:");
//			String password = sc.nextLine();
//
//			JDBCUtil jdbcUtil = new JDBCUtil();
//			Connection connection = jdbcUtil.getConnection();
//			Statement stmt = connection.createStatement();
//
////			String find = "SELECT * FROM usermanagement WHERE username = '"+userName+"' AND password = '"+password+"'";
//			String find = "SELECT * FROM usermanagement WHERE username = '" + userName + "' AND password = '" + password
//					+ "'";
//
//			ResultSet resultSet = stmt.executeQuery(find);
//
//			if (resultSet.next()) {
//				System.out.println("Login in");
//			} else {
//				System.out.println("Invalid Credentials");
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
	}

	public static void prepareStatement() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Valid userName:");
			String userName = sc.nextLine();

			System.out.println("Enter Valid password:");
			String password = sc.nextLine();

			JDBCUtil jdbcUtil = new JDBCUtil();
			Connection connection = jdbcUtil.getConnection();

			String query = "SELECT * FROM usermanagement WHERE username = ? and password= ?";

			PreparedStatement pstmt = connection.prepareStatement(query);

			pstmt.setString(1, userName);
			pstmt.setString(2, password);

			ResultSet rset = pstmt.executeQuery();

			if (rset.next()) {
				System.out.println("Login Successfull");
			} else {
				System.out.println("Invalid Credentials");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	

}
