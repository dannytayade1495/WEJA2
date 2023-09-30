package com.jspiders.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.studentmanagement.exception.InvalidEmailException;
import com.jspiders.studentmanagement.pojo.StudentPOJO;
import com.jspiders.studentmanagement.response.StudentResponse;
import com.jspiders.studentmanagement.service.StudentService;

@RestController
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody StudentPOJO pojo) {
		try {
			StudentPOJO student = service.addStudent(pojo);

			if (student != null) {
				return new ResponseEntity<StudentResponse>(
						new StudentResponse("Student data added successfully. ", student, null), HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not added. ", student, null),
					HttpStatus.NOT_ACCEPTABLE);
		} catch (InvalidEmailException e) {
			return new ResponseEntity<InvalidEmailException>(new InvalidEmailException(true, "Invalid email. "),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchById(@PathVariable int id){
		StudentPOJO pojo = service.searchById(id);
		if (pojo != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully. ", pojo, null), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", pojo, null), HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping("/searchAll")
	public ResponseEntity<?> searchAll(){
		List<StudentPOJO> students = service.searchAll();
		if (students.isEmpty() == false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully. ", null, students), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", null, null), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/searchByName/{name}")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		List<StudentPOJO> students = service.searchByName(name);
		if (students.isEmpty() == false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully. ", null, students), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", null, null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/searchByEmail/{email}")
	public ResponseEntity<?> searchByEmail(@PathVariable String email){
		List<StudentPOJO> students = service.searchByEmail(email);
		if (students.isEmpty() == false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully. ", null, students), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", null, null), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/searchByAddress/{address}")
	public ResponseEntity<?> searchByAddress(@PathVariable String address){
		List<StudentPOJO> students = service.searchByAddress(address);
		if (students.isEmpty() == false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student data found successfully. ", null, students), HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student data not found. ", null, null), HttpStatus.BAD_REQUEST);
	}
}
