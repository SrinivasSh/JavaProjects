package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping("/send")
	public String sendData(Model model) {
		model.addAttribute("name", "Srinivas");
		return "welcome";
	}

	@PostMapping("/signUp")
	public String getData(Model model, HttpServletRequest request) {
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");

		model.addAttribute("email", email);
		model.addAttribute("password", password);
		return "data";
	}

}
