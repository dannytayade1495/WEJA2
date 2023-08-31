package com.jspiders.springcore.beans;

import org.springframework.beans.factory.annotation.
												Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class PersonBean {
	
	private int id;
	private String name;
	private AadharBean aadhar;
	
	@Autowired
	public PersonBean(int id, String name, AadharBean aadhar) {
		this.id = id;
		this.name = name;
		this.aadhar = aadhar;
	}
	
	

}
