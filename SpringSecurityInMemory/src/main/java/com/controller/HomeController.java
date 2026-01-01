package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/hello")
	public String hello() {
		return "Hi welcome to Spring Security!! ";
	}

	@GetMapping("/close")
	public String close() {
		return "Hi today spring security class will windup earlier! ";
	}

	@GetMapping("/accessAll")
	public String allow() {
		return "Hi you are accessble to all api's ";
	}

	@GetMapping("/denyAll")
	public String deny() {
		return "Hi you are denied to access this api!! ";
	}

}
