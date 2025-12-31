package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchProcessing {

	public static void main(String[] args) {

		try {
			JDBCUtil jdbcUtil = new JDBCUtil();

			Connection connection = jdbcUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("insert into student values(?,?,?)");
			pstmt.setInt(1, 7);
			pstmt.setString(2, "DTS@gmail.com");
			pstmt.setInt(3, 1541696);

			pstmt.addBatch();

			pstmt.setInt(1, 8);
			pstmt.setString(2, "Kris@gmail.com");
			pstmt.setInt(3, 1541696);

			pstmt.addBatch();

			pstmt.executeBatch();
			connection.commit(); 

			System.out.println("Multiple Data inserted!...");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
