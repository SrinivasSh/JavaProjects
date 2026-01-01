package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Employee emp = context.getBean("emp", Employee.class);
		System.out.println(emp);

		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);
		System.out.println(emp == emp);

	}

}
