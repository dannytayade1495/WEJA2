package com.jspiders.servlet.servlets;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet1 extends GenericServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	public void service
	(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Hello World!");
		
	}

}
