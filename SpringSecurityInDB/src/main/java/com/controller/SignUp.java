package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.model.Person;
import com.service.PersonService;

@RestController
public class SignUp {

	@Autowired
	PersonService personService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/signUp")
	public Person signUp(@RequestBody Person person) {
		String encodedPassword = passwordEncoder.encode(person.getPassword());
		person.setPassword(encodedPassword);
		return personService.signUpPage(person);

	}

}
