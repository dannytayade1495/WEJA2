package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;

	//Home page Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false)AdminPOJO admin,
						ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Add page Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
				return "Add";
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Add student Controller
	@PostMapping("/add")
	public String addStudent(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam String name,
								@RequestParam String email,
								@RequestParam long contact,
								@RequestParam String address,
								ModelMap map) {
		if (admin != null) {
			StudentPOJO pojo = service.addStudent(name, email, contact, address);
			
			//Success
			if (pojo != null) {
				map.addAttribute("msg","Data inserted successfully..!");
				List<StudentPOJO> students = service.findAllStudents();
				map.addAttribute("students", students);
				return "Add";
			}
			//Failure
			map.addAttribute("msg","Data not inserted..!");
			List<StudentPOJO> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
		
	}
	
	//Search page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false)AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Search student Controller
	@PostMapping("/search")
	public String searchStudent(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								ModelMap map) {
		if (admin != null) {
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
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Remove page Controller
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			//Success
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
				return "Remove";
			}
			map.addAttribute("msg", "No data present..!");
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Remove student Controller
	@PostMapping("/remove")
	public String removeStudent(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								ModelMap map) {
		if (admin != null) {
			StudentPOJO pojo = service.removeStudent(id);
			List<StudentPOJO> students = service.findAllStudents();
			
			//Success
			if (pojo != null) {
				map.addAttribute("msg", "Data removed successfully..!");
				map.addAttribute("students", students);
				return "Remove";
			}
			//Failure
			map.addAttribute("msg", "Data does not exist..!");
			map.addAttribute("students", students);
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Update page Controller
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Update form Controller
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								ModelMap map) {
		if (admin != null) {
			StudentPOJO pojo = service.searchStudent(id);
			//Success
			if (pojo != null) {
				map.addAttribute("student",pojo);
				return "Update";
			}
			//Failure
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students", students);
			map.addAttribute("msg", "Student data not found..!");
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
	//Update student Controller
	@PostMapping("/updateStudent")
	public String updateStudent(@SessionAttribute(name = "login", required = false)AdminPOJO admin,@RequestParam int id,
								@RequestParam String name,
								@RequestParam String email,
								@RequestParam long contact,
								@RequestParam String address,
								ModelMap map) {
		if (admin != null) {
			StudentPOJO pojo = service.updateStudent(id, name, email, contact, address);
			//Success
			if (pojo != null) {
				List<StudentPOJO> students = service.findAllStudents();
				map.addAttribute("msg", "Data updated successfully..!");
				map.addAttribute("students", students);
				return "Update";
			}
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("msg", "Data not updated..!");
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Login to proceed..!");
		return "Login";
	}
	
}
