package com.Mappings;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Orders;
import com.Entity.Person;
import com.configuration.HibernateUtil;

public class OneToMany {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Person person = new Person("Bhargav", "Goa");

		Orders order1 = new Orders(11, "Mobile");
		Orders order2 = new Orders(21, "Laptop");
		Orders order3 = new Orders(31, "T-shirts");

		order1.setPerson(person);
		order2.setPerson(person);
		order3.setPerson(person);

		List<Orders> orderList = new ArrayList<Orders>();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);

		person.setOrders(orderList);

		// insert(session, person);

		// selectData(session);

		// UpdateData(session);

		deleteData(session);

	}

	private static void deleteData(Session session) {
		Person deletePerson = session.find(Person.class, 1);
		session.beginTransaction();
		session.remove(deletePerson);
		session.getTransaction().commit();
	}

	public static void UpdateData(Session session) {
		session.beginTransaction();
		Person findPerson = session.find(Person.class, 2);
		findPerson.setLocation("Palnadu");
		List<Orders> orders = findPerson.getOrders();
		Orders findOrder = orders.get(1);
		findOrder.setProductName("Gym Equipment");
		session.merge(findPerson);
		session.getTransaction().commit();
	}

	public static void selectData(Session session) {
		Person selectPerson = session.find(Person.class, 2);
		System.out.println(selectPerson);
		// System.out.println(selectPerson.getOrders());
	}

	public static void insert(Session session, Person person) {
		session.beginTransaction();
		session.persist(person);
		session.getTransaction().commit();
	}

}
