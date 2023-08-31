package com.jspiders.springcore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonBean {
	
	int id;
	String name;
	AadharBean aadhar;

}
