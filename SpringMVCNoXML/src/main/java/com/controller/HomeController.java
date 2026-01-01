package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

	@RequestMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("name", "Srinivas");
		return "signUp";
	}

	@PostMapping("/login")
	public String login(Model model, HttpServletRequest request) {
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		model.addAttribute("email", email);
		model.addAttribute("userName", "SrinivasSh");
		return "success";

	}

}
