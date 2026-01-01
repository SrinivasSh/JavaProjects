package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConfigApplication {

	public static void main(String[] args) {

//		SessionFactory sf = HibernateUtil.getSessionFactory();
//
//		Session session = sf.openSession();
//
//		Student student = new Student(12, "Varsha", 95, 25, "Hyderabad", "Econimics");
//
//		session.beginTransaction();
//		session.persist(student);
//		session.getTransaction().commit();
//
//		System.out.println("Data Inserted!!!...");
		
		//getData();
		//updateData();
		deleteData();

	}
	public static void getData() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		System.out.println(session.find(Student.class, 9));
		
	}
	
	
	public static void updateData() {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		
		Student student=session.find(Student.class, 5);
		student.setMarks(75);
		student.setLocation("Bondilipuram");
		student.setDept("Maths");
		student.setName("Suresh");
		session.beginTransaction();
		session.merge(student);
		session.getTransaction().commit();
		System.out.println("Data Updated!...");
		
	}
	
	public static void deleteData() {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		
		Student student=session.find(Student.class,17);
	
		session.beginTransaction();
		session.remove(student);
		session.getTransaction().commit();
		System.out.println("Data deleted!...");
		
	}
		
	
}



