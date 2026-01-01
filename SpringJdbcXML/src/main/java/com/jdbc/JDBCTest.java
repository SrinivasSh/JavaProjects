package com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest {
	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("beans.xml");
		JdbcTemplate template = container.getBean("jdbcTemplate", JdbcTemplate.class);

		// DML Operations

		// template.update("insert into employee values(?,?,?,?)",
		// 8,"Google","Mahendra","Hyderabad");// Insert
		// template.update("update employee set empName=? where empId=?", "Krishna",6);
		// //update
		// template.update("delete from employee where empId=?", 8); //Delete operations

		// DQL Operations

		Employee employee = template.queryForObject("select * from employee where empId=?", new RowMapper<Employee>() {

			// using Annoymous Inner Class
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		}, 7);

		System.out.println("Employee using annonymous InnserClass:" + employee);
		System.out.println("==========================");

		// List of employee
		List<Employee> employeeList = template.query("select * from employee", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		});

		System.out.println("Emp List:" + employeeList);
		System.out.println("==========================");

		// Using lamda Expressions

		List<Employee> employees = template.query("select * from employee",
				(rs, num) -> new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));

		System.out.println("Employees Using Lamda:" + employees);

	}

}
