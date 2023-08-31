package com.jspiders.springcore.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcore.beans.EmployeeBean;

public class EmployeeConfig {
	
	@Bean
	public EmployeeBean getEmployee() {
		return new EmployeeBean();
	}

}
