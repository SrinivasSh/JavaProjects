package com.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;

	public String emailSender(String toEmail) {
		SimpleMailMessage email = new SimpleMailMessage();
		SecureRandom random=new SecureRandom();
		int randomNumber=random.nextInt(900000);
		email.setFrom("srinivasshanmukh999@gmail.com");
		email.setTo(toEmail);
		email.setSubject("JFS Course Login");
		email.setText("You are Succefully Login to Jfs Course");
		email.setCc("shsrinivasdm97@gmail.com");
		email.setText("Your Otp is:"+randomNumber);
		javaMailSender.send(email);
		return "Otp sent to your email!!";

	}

}
