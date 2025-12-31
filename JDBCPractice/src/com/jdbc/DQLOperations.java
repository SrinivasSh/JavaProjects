package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DQLOperations {

	public static void main(String[] args) throws SQLException {
		try {
			JDBCUtil jdbcUtil = new JDBCUtil();

			Connection connection = jdbcUtil.getConnection();

			Statement statement = connection.createStatement();

			String selectQuery = "Select * from student";

			ResultSet result = statement.executeQuery(selectQuery);
			System.out.println("id\temail\trollNumber");
			while (result.next()) {
				int userId = result.getInt(1);
				String email = result.getString(2);
				int rollNumber = result.getInt(3);

				System.out.println(userId + "\t" + email + "\t" + rollNumber);

			}

			System.out.println("Retrieve Data from student table");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
