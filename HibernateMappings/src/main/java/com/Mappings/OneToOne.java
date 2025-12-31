package com.Mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Passport;
import com.Entity.User;
import com.configuration.HibernateUtil;

public class OneToOne {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		
		//insert(session);
		//findData(session);
		
		//updateData(session);
		//delete(session);
		
		Passport passport=session.find(Passport.class, 151275);
		System.out.println(passport);
		
	}

	public static void delete(Session session) {
		session.beginTransaction();
		session.remove(new User(2,"", new Passport(15155,"")));
		session.getTransaction().commit();
	}

	public static void updateData(Session session) {
		session.beginTransaction();
		User user=session.find(User.class,4);
		user.setName("Anketh");
		session.merge(user);
		session.getTransaction().commit();
	}

	public static void findData(Session session) {
		User user=session.find(User.class, 3);
		System.out.println(user);
	}

	public static void insert(Session session) {
//		User user=new User("Kalyan",new Passport(151748,"Kerala"));
//		session.beginTransaction();
//		session.persist(user);
//		session.getTransaction().commit();
		
		Passport passport=new Passport(151275,"Andhra Pradesh");
		User user=new User("Deevali");
		user.setPassport(passport);
		passport.setUser(user);
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}

}
