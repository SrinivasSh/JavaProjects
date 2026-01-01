package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MobileTest {

	@Autowired
	@Qualifier("samsung")
	public Mobile mobile;

	public void brand() {
		mobile.brand();
	}
}
