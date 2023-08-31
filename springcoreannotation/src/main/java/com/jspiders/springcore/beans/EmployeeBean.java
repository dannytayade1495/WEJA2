package com.jspiders.springcore.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBean {
	
	@Value("1")
	private int id;
	
	@Value("Amit")
	private String name;
	
	@Value("amit@gmail.com")
	private String email;
	
	@Value("Wakad")
	private String address;

}
