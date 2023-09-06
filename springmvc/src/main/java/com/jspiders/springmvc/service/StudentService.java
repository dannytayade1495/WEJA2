package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(String name, String email, long contact, String address) {
		StudentPOJO pojo = repository.addStudent(name, email, contact, address);
		return pojo;
	}

	public StudentPOJO searchStudent(int id) {
		StudentPOJO pojo = repository.searchStudent(id);
		return pojo;
	}

	public List<StudentPOJO> findAllStudents() {
		List<StudentPOJO> students = repository.findAllStudents();
		return students;
	}

	public StudentPOJO removeStudent(int id) {
		StudentPOJO pojo = repository.removeStudent(id);
		return pojo;
	}

	public StudentPOJO updateStudent(int id, String name, String email, long contact, String address) {
		StudentPOJO pojo = repository.updateStudent(id, name, email, contact, address);
		return pojo;
	}

}
