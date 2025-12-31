package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLOperations {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Register a driver (Optional)

//		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Driver Class");

		// 2. Establish a connection

		String url = "jdbc:mysql://localhost:3306/flm_db";
		String userName = "root";
		String password = "Srinivas@1998";

		Connection connection = DriverManager.getConnection(url, userName, password);

		// 3. Create a statement

		Statement statement = connection.createStatement();

		// 4. Prepare a sql query

		 String insertQuery="insert into employee_data values(8,'Chukka','Railways','Hyderabad','TCS')";

		// String deleteQuery="delete from employee_data where empId=8";

		// String updateQuery="update employee_Data set skills='Business Analyst' where
		// empId=6";

		// String findData="Select * from employee_Data where empName='Srinivas'";

		// 5. Execute query
		 statement.executeUpdate(insertQuery);

		// statement.executeUpdate(deleteQuery);

		// statement.executeUpdate(updateQuery);

		System.out.println("Inserted Data");

	}

}
