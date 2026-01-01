package com;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Realme implements Mobile {

	public void brand() {
		System.out.println("Realme G7 Pro");

	}

}
