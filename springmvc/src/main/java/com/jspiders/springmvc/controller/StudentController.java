package com.jspiders.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;

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
	
	//Add student Controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name,
								@RequestParam String email,
								@RequestParam long contact,
								@RequestParam String address,
								ModelMap map) {
		StudentPOJO pojo = service.addStudent(name, email, contact, address);
		
		//Success
		if (pojo != null) {
			map.addAttribute("msg","Data inserted successfully..!");
			return "Add";
		}
		//Failure
		map.addAttribute("msg","Data not inserted..!");
		return "Add";
	}
	
	//Search page Controller
	@GetMapping("/search")
	public String searchPage() {
		return "Search";
	}
	
	//Search student Controller
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id,
								ModelMap map) {
		StudentPOJO pojo = service.searchStudent(id);
		//Success
		if (pojo != null) {
			map.addAttribute("student",pojo);
			map.addAttribute("msg","Student data found..!");
			return "Search";
		}
		//Failure
		map.addAttribute("msg", "Student data not found..!");
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
