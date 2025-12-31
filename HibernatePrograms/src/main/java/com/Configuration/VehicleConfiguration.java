package com.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Vehicle;
import com.entity.VehicleNo;

public class VehicleConfiguration {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		//insertData(session);
		
		findData(session);
		
		
		
		
	}
	public static void findData(Session session) {
		Vehicle veh=session.find(Vehicle.class, new VehicleNo(2,"5166hbhj16"));
		System.out.println(veh);
	}

	public static void insertData(Session session) {
		session.beginTransaction();
		Vehicle vehicle=new Vehicle(new VehicleNo(2,"5166hbhj16"),"Scooty",100000);
		session.persist(vehicle);
		session.getTransaction().commit();
	}
}
