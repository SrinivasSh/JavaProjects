package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.User;

@RestController
public class UserController {
	
	@Autowired
	User user;
	
	@GetMapping("/getDetails")
	public User getUserDetails() {
		return user;
	}

}
