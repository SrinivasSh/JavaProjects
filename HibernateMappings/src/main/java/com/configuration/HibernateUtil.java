package com.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Entity.IplFrancise;
import com.Entity.Orders;
import com.Entity.Passport;
import com.Entity.Person;
import com.Entity.Player;
import com.Entity.User;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Passport.class);
			cfg.addAnnotatedClass(Person.class);
			cfg.addAnnotatedClass(Orders.class);
			cfg.addAnnotatedClass(IplFrancise.class);
			cfg.addAnnotatedClass(Player.class);
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;

	}

}
