package com.jspiders.springcore.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcore.beans.StudentBean;

public class StudentConfig {
	
	@Bean
	public StudentBean getStudent() {
		StudentBean student1 = new StudentBean();
		student1.setId(1);
		student1.setName("Arjun");
		student1.setEmail("arjun@gmail.com");
		return student1;
	}
	
	@Bean("student2")
	public StudentBean getStudent1() {
		return new StudentBean
				(2, "Karan", "karan@gmail.com");
	}

}
