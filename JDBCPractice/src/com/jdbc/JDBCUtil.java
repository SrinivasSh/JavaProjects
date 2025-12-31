package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	public Connection connection = null;

	public Connection getConnection() throws SQLException {

		if (connection == null) {

			connection = DriverManager.getConnection(JDBCConstants.url, JDBCConstants.userName, JDBCConstants.password);

		}

		return connection;

	}

}
