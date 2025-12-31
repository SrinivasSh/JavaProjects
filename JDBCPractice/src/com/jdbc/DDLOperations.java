package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDLOperations {

	public static void main(String[] args) throws SQLException {
		try {
		JDBCUtil jdbcUtil = new JDBCUtil();
		Connection connection = jdbcUtil.getConnection();

		Statement statement = connection.createStatement();
		String createTable = "create table userManagement(userName varchar(20), password varchar(20))";
		statement.executeUpdate(createTable);

		System.out.println("User table created...");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
