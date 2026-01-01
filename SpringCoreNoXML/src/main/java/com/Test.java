package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.Config;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Employee emp = context.getBean(Employee.class);
		System.out.println(emp);

		MobileTest mbTest = context.getBean(MobileTest.class);
		mbTest.brand();

	}

}
