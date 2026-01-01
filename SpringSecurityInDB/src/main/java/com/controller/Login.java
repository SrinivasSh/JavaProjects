package com.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Person;

@RestController
public class Login {

	@PostMapping("/login")
	public String login(@RequestBody Person person) {
		return "You are successfully Login!";
	}

}
