package com.Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static SessionFactory sessionFactory=null;
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			Configuration cfg=new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Student.class);
			SessionFactory sessionFactory=cfg.buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
		
	}

}
