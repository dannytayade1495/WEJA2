package com.jspiders.springcore.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {
	
	private int id;
	private String name;
	private String email;

}
