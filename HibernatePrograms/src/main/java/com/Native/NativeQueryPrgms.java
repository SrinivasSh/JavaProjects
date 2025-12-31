package com.Native;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;

import com.Configuration.HibernateUtil;
import com.entity.Employee;

public class NativeQueryPrgms {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// nativeSelect(session);

		// nativeWhere(session);

		// nativeInsert(session);
		//nativeUpdate(session);
		
		nativeDelete(session);
		

	}


	// DQL OPERATIONS(SELECT)
	public static void nativeSelect(Session session) {
		NativeQuery<Employee> query = session.createNativeQuery("Select * from employee", Employee.class);
		List<Employee> list = query.list();

		for (Employee emp : list)
			System.out.println(emp);
	}

	// SELECT WITH WHERE OPERATIONS
	public static void nativeWhere(Session session) {
		NativeQuery<Employee> query = session.createNativeQuery("Select * from employee where empName=?1",
				Employee.class);
		query.setParameter(1, "Prasad");
		List<Employee> list = query.list();
		// query.executeUpdate();
		System.out.println(list);
	}

	// DML OPERATIONS(INSERT)
	public static void nativeInsert(Session session) {
		session.beginTransaction();
		MutationQuery query = session
				.createNativeMutationQuery("insert into employee(empName,company,location) values(?1,?2,?3)");
		query.setParameter(1, "Sahil");
		query.setParameter(2, "Synopsis");
		query.setParameter(3, "Shimla");
		query.executeUpdate();
		session.getTransaction().commit();
	}

	// Update Operation
	public static void nativeUpdate(Session session) {
		session.beginTransaction();
		MutationQuery query = session.createNativeMutationQuery("Update employee set empName=?1 where empId=?2");
		query.setParameter(1, "Ramya");
		query.setParameter(2, 6);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	
	//DELETE OPERATION
	public static void nativeDelete(Session session) {
		session.beginTransaction();
		MutationQuery query=session.createNativeMutationQuery("delete from employee where empId=?1");
		query.setParameter(1, 4);
		query.executeUpdate();
		session.getTransaction().commit();
	}

}
