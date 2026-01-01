package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;

@Controller
public class UserData {

	@GetMapping("/send")
	public String sendData() {

		return "Data";
	}

	@GetMapping("/home")
	public String sendUser(Model model) {
		model.addAttribute("name", "Srinivas");
		model.addAttribute("password", "Srinivas@616");
		model.addAttribute("user", new User());
		return "home";
	}

	@GetMapping("/submit") /// From jsp to java using anchor tag
	public String formSubmit() {

		return "Success";
	}

	@PostMapping("/form") /// Retrieve details from (jsp to java) using form data Here using RequestParam
							/// to get details
	public String submit(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		return "Login";
	}

	@PostMapping("/formObject") /// Retrieve details from (jsp to java) using form data Here using
								/// @ModelAttribute using model class to get details
	public String formObject(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("username", user.getName());
		model.addAttribute("password", user.getPassword());
		return "Details";
	}

	@GetMapping("/users") /// Retrieve details from (jsp to java) using form data Here using
							/// @ModelAttribute using model class to get details
	public String users(Model model) {
		List<User> users = new ArrayList<User>();
		users.add(new User("Hani", "Hani@11653"));
		users.add(new User("Vamsi", "V@ms!@94585"));
		users.add(new User("Shunurhi", "Shunthi@%949"));
		model.addAttribute("userList", users);
		return "Users";
	}

}
