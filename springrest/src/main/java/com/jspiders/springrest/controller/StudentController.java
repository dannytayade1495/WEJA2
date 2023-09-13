package com.jspiders.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.response.StudentResponse;
import com.jspiders.springrest.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentPOJO pojo) {

		StudentPOJO student = service.addStudent(pojo);

		// SUCCESS
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data added successfully. ", student, null),
					HttpStatus.ACCEPTED);
		}

		// FAILURE
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not added. ", null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping(path = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> searchStudent(@PathVariable int id) {
		StudentPOJO student = service.searchStudent(id);

		// SUCCESS
		if (student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data found successfully. ", student, null),
					HttpStatus.FOUND);
		}

		// FAILURE
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not found. ", student, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> searchAllStudents() {
		List<StudentPOJO> students = service.searchAllStudent();

		// SUCCESS
		if (students.isEmpty() == false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data found successfully. ", null, students),
					HttpStatus.FOUND);
		}

		// FAILURE
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not found. ", null, null),
				HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> removeStudent(@PathVariable int id) {
		StudentPOJO student = service.removeStudent(id);

		// SUCCESS
		if (student != null) {
			return new ResponseEntity<StudentResponse>(
					new StudentResponse("Data removed successfully. ", student, null), HttpStatus.OK);
		}

		// FAILURE
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not removed. ", null, null),
				HttpStatus.BAD_REQUEST);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentPOJO pojo) {
		StudentPOJO student = service.updateStudent(pojo);

		// SUCCESS
		if (student != null) {
			return new ResponseEntity<StudentResponse>(
					new StudentResponse("Data updated successfully. ", student, null), HttpStatus.ACCEPTED);
		}

		// FAILURE
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not updated. ", null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}

}
