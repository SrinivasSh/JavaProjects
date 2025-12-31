package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connection = null;

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		if (connection == null) {
			connection = DriverManager.getConnection(DBConstants.URL, DBConstants.USERNAME, DBConstants.PASSWORD);
		}
		return connection;

	}

}
