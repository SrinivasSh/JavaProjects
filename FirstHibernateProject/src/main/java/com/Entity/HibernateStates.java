package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateStates {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Student student=new Student("Kishore",75,26,"Etcherala","ECE");    ///Object in Transcient State no relation with session
		Session session = sf.openSession();
		
//		session.beginTransaction();
//		//session.persist(student);    //// OBJECT IN PERSCIENT STATE
//		
//		session.getTransaction().commit();
//		
//		session.close();     ///OBJECT IN DETACHED STATE
		
	
		
		
	}

}
