package com.jspiders.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	//Home page Controller
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	
	//Add page Controller
	@GetMapping("/add")
	public String addPage() {
		return "Add";
	}
	
	//Search page Controller
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}
	
	//Remove page Controller
	@GetMapping("/remove")
	public String removePage() {
		return "Remove";
	}
	
	//Update page Controller
	@GetMapping("/update")
	public String updatePage() {
		return "Update";
	}
	
	//Logout Controller
	@GetMapping("/logout")
	public String logout() {
		return "Login";
	}

}
