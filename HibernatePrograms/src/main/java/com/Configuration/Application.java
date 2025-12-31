package com.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;

public class Application {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Employee employee=new Employee("Kiran","Mecloyds","Vizag");
		Employee employe1=new Employee("Prasad","Medminar","VijayaNagaram");
		Employee employe2=new Employee("Sasi","Fintech","Hyderabad");
		session.beginTransaction();
		session.persist(employee);
		session.persist(employe1);
		session.persist(employe2);
		session.getTransaction().commit();
		session.close();

	}

}
