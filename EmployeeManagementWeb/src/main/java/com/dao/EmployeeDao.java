package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DBConnection;
import com.jdbc.DBConstants;
import com.model.Employee;

public class EmployeeDao {

	public List<Employee> getAllEmployes() {
		Connection connection;
		List<Employee> empList = new ArrayList<>();

		try {
			connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(DBConstants.GET_ALL_EMPLOYEES);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int empId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String email = resultSet.getString(4);
				String phoneNumber = resultSet.getString(5);
				double salary = resultSet.getDouble(6);

				Employee employee = new Employee(empId, name, age, email, phoneNumber, salary);
				empList.add(employee);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return empList;

	}
	
	
	public void saveEmployee(Employee employee) {
		
		try {
			Connection connection=DBConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement(DBConstants.SAVE_EMPLOYEE);
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3,employee.getEmail());
			statement.setString(4,  employee.getNumber());
			statement.setDouble(5,  employee.getSalary());
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteEmployee(int id) {
		try {
			Connection connection=DBConnection.getConnection();
			PreparedStatement statement=connection.prepareStatement(DBConstants.DELETE_EMPLOYEE);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public Employee getEmployee(int id) {
		Employee employee = null;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(DBConstants.GET_EMPOLYEE);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int empId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String email = resultSet.getString(4);
				String phoneNumber = resultSet.getString(5);
				double salary = resultSet.getDouble(6);

				employee = new Employee(empId, name, age, email, phoneNumber, salary);

			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return employee;
	}
	
	public void updateEmployee(Employee employee) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(DBConstants.UPDATE_EMPLOYEE);
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getEmail());
			statement.setString(4, employee.getNumber());
			statement.setDouble(5, employee.getSalary());
			statement.setInt(6, employee.getEmpId());

			statement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
}
