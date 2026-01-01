package com.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.Config;
import com.dao.EmployeeDao;
import com.model.Employee;

public class HibernateTest {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
		Employee employee = employeeDao.getEmployee(1); // fetch data
		System.out.println(employee);

		// Insert data
		// employeeDao.saveEmployee(new
		// Employee("ShabhamSri@gmail.com","Shubham","Sri"));

		// UPDATE DATA
		// employeeDao.updateEmployee();

		// Delete Data
		employeeDao.deleteEmployee();

	}

}
