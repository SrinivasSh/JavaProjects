package com.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.Student;
import com.entity.Vehicle;

public class HibernateUtil {
	
	public static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory==null) {
			Configuration cfg=new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Employee.class);
			cfg.addAnnotatedClass(Vehicle.class);
			cfg.addAnnotatedClass(Student.class);
			SessionFactory sessionFactory=cfg.buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
		
	}

}
