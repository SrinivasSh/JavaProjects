package com.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hi")
	@PreAuthorize("hasRole('SUPERADMIN')")
	public String hi() {
		return "Hi you have valid JWT";
	}

	@GetMapping("/open")
	public String open() {
		return "You can access without JWT";
	}

	@GetMapping("/add")
	public String add() {
		return "Successfully Add a new Employee in the team!";
	}

	@GetMapping("/revenue")
	public String revenue() {
		return "Your total revenue is 1000000 rupees";
	}
}
