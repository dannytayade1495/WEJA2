package com.jspiders.springcore.bean;

import java.util.List;

import lombok.Data;

@Data
public class CompanyBean {
	
	int id;
	String name;
	List<EmployeeBean> employees;

}
