package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TclOperations {

	public static Connection connection;

	public static void main(String[] args) throws SQLException {

		try {
			JDBCUtil jdbcUtil = new JDBCUtil();

			connection = jdbcUtil.getConnection();

			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement("update flmstudents set location =? where id=?");
			pstmt.setString(1, "Bheemli");
			pstmt.setInt(2, 4);

			pstmt.executeUpdate();

			connection.commit();
			//connection.rollback();

		} catch (Exception e) {
			connection.rollback();
			System.out.println(e.getMessage());

		}

	}
}
