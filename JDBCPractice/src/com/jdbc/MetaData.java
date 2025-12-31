package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaData {
	
	public static void main(String[] args) throws SQLException {
		try {
		JDBCUtil jdbcUtil=new JDBCUtil();
		
		Connection connection=jdbcUtil.getConnection();
		
		
		String query="Select * from flmstudents";
		PreparedStatement pstmt=connection.prepareStatement(query);
		
		ResultSet rset=pstmt.executeQuery();
		System.out.println("id\tname\tmarks\tage\tlocation\tdept");
		while(rset.next()) {
			int id=rset.getInt(1);
			String name=rset.getString(2);
			int marks=rset.getInt(3);
			int age=rset.getInt(4);
			String location=rset.getString(5);
			String dept=rset.getString(6);
			
			
			System.out.println(id+"\t"+name+"\t"+marks+"\t"+age+"\t"+location+"\t"+dept);
		}
		
		ResultSetMetaData metaData=rset.getMetaData();
		
		System.out.println(metaData.getColumnCount());
		
		for(int i=1;i<=metaData.getColumnCount();i++) {
			System.out.print(metaData.getColumnName(i));
			System.out.print("\t");
		}
		
		System.out.println("Column Type:"+metaData.getColumnType(1));
		System.out.println("Column Type Name:"+metaData.getColumnTypeName(1));
		System.out.println("Column Label:"+metaData.getColumnLabel(1));
		System.out.println("Column Scale:"+metaData.getScale(1));
		System.out.println("Schema Name:"+metaData.getSchemaName(3));
		System.out.println("Table Name:"+metaData.getTableName(1));
		System.out.println("Catelog Name:"+metaData.getCatalogName(2));
		System.out.println("Precision:"+metaData.getPrecision(1));
		
	}
		catch(Exception c) {
			System.out.println(c.getMessage());
		}
	
	}

}
