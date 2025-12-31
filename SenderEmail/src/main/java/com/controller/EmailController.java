package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;

	@GetMapping("/send")
	public String sendEmail(@RequestParam(name = "toEmail") String toEmail) {
		return emailService.emailSender(toEmail);
	}

}
