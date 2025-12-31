package com.NamedQueries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.Configuration.HibernateUtil;
import com.entity.Student;

public class NamedQueries {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		Student student=new Student("Hari","Ongolu");
		Student student1=new Student("Varshu","Bengal");
		Student student2=new Student("Harini","Goa");
		
		//InsertData(session, student, student1, student2);
		
		//selectData(session);
		
		//selectWhere(session);
		
		
		//updateData(session);

		
		deleteData(session);
		
		
	}

	public static void deleteData(Session session) {
		session.beginTransaction();
		MutationQuery query=session.createNamedMutationQuery("deleteStudent");
		query.setParameter(1, 2);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public static void updateData(Session session) {
		session.beginTransaction();
		MutationQuery query=session.createNamedMutationQuery("updateStudent");
		query.setParameter(1, "Mahadhev");
		query.setParameter(2, 1);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public static void selectWhere(Session session) {
		Query<Student> query=session.createNamedQuery("selectedStudent", Student.class);
		query.setParameter(1, 3);
		List<Student> stud=query.list();
		System.out.println(stud);
	}

	public static void selectData(Session session) {
		Query<Student> query=session.createNamedQuery("allStudents",Student.class);
		List<Student> list=query.list();
		System.out.println(list);
	}

	public static void InsertData(Session session, Student student, Student student1, Student student2) {
		session.beginTransaction();
		session.persist(student2);
		session.persist(student1);
		session.persist(student);
		session.getTransaction().commit();
		
	
	}
	
	

}
