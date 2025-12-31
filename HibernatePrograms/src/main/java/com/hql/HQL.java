package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.Configuration.HibernateUtil;
import com.entity.Employee;

public class HQL {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// select(session);

		// selectWhere(session);
		// insert(session);

		// updateData(session);

		removeData(session);

	}
	//DQL OPERATIONS(SELECT)
	public static void select(Session session) {
		SelectionQuery<Employee> query = session.createSelectionQuery("From Employee", Employee.class);
		List<Employee> list = query.list();
		System.out.println(list);
	}
	
	//SELECT WITH WHERE OPERATIONS
	public static void selectWhere(Session session) {
		SelectionQuery<Employee> query = session.createSelectionQuery("From Employee where empName=?1", Employee.class);
		query.setParameter(1, "Sasi");
		List<Employee> empList = query.list();
		System.out.println(empList);
	}

	//DML OPEARTIONS(INSERT)
	public static void insert(Session session) {
		session.beginTransaction();
		MutationQuery query = session
				.createMutationQuery("insert into Employee(empName,company,location) values(?1,?2,?3)");
		query.setParameter(1, "Kethan");
		query.setParameter(2, "Cognizant");
		query.setParameter(3, "Chennai");
		query.executeUpdate();
		session.getTransaction().commit();
	}

	//UPDATE OPERATIONS
	public static void updateData(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createMutationQuery("update Employee set location=?1 where empId=?2");
		query.setParameter(1, "Himachal");
		query.setParameter(2, 5);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	//DELETE OPERATIONS
	public static void removeData(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createMutationQuery("Delete from Employee where empId=?1");
		query.setParameter(1, 5);
		query.executeUpdate();
		session.getTransaction().commit();
	}

}
