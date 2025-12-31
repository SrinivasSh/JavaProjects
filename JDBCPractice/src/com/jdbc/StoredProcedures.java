package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class StoredProcedures {
	
	public static void main(String[] args) {
		try {
			JDBCUtil jdbcUtil = new JDBCUtil();

			Connection connection = jdbcUtil.getConnection();
			CallableStatement cstmt = connection.prepareCall("{call getAllFlmStudents()}");
			
			ResultSet resultSet=cstmt.executeQuery();
			
			while(resultSet.next()) {
			 System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getInt(4)+"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6));
			}
			

			System.out.println("Data called using stored prcedures...");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

}
