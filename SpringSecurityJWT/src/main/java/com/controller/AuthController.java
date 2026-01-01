package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.repository.EmployeeRepository;
import com.security.JWTService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;

	@PostMapping("/signUp")
	public Employee signUp(@RequestBody Employee employee) {
		String encodedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(encodedPassword);

		return employeeRepository.save(employee);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Employee employee) {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(employee.getEmail(), employee.getPassword()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
		}

		String token = jwtService.generateToken(employee.getEmail());
		return ResponseEntity.ok(token);

	}

}
