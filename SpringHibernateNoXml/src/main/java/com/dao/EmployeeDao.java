package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.model.Employee;

@Component
@Transactional
public class EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	// DQL OPERATION
	public Employee getEmployee(int id) {
		Session session = getSession();
		return session.find(Employee.class, id);
	}

	// DML OPERATON(INSERT, UPDATE ,DELETE)

	// INSERT
	public void saveEmployee(Employee employee) {
		Session session = getSession();
		session.persist(employee);
	}

	// UPDATE
	public void updateEmployee() {
		Session session = getSession();
		Employee employee = session.find(Employee.class, 1);
		employee.setEmailId("srinivas77@gmail.com");
		session.merge(employee);
	}

	// DELETE
	public void deleteEmployee() {
		Session session = getSession();
		Employee employee = session.find(Employee.class, 6);
		session.remove(employee);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
