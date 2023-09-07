package com.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	//Create Account Page Controller
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map) {
		AdminPOJO pojo = service.getAdmin();
		
		if (pojo != null) {
			map.addAttribute("msg", "Account already exists..!");
			return "Login";
		}
		return "CreateAccount";
	}
	
	//Create Account Controller
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,
							@RequestParam String password,
							ModelMap map) {
		AdminPOJO pojo = service.createAccount(username, password);
		
		//Success
		if (pojo != null) {
			map.addAttribute("msg", "Account created successfully..!");
			return "Login";
		}
		
		//Failure
		map.addAttribute("msg", "Account not created..!");
		return "Login";
	}
	
	//Login Controller
	@PostMapping("/login")
	public String login(@RequestParam String username,
						@RequestParam String password,
						ModelMap map) {
		AdminPOJO pojo = service.login(username, password);
		//Success
		if (pojo != null) {
			return "Home";
		}
		map.addAttribute("msg", "Invalid username or password..!");
		return "Login";
	}
	
	//Logout Controller
		@GetMapping("/logout")
		public String logout(ModelMap map) {
			map.addAttribute("msg", "Logged out successfully..!");
			return "Login";
		}

}
