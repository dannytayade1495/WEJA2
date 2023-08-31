package com.jspiders.servlet.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet1 extends GenericServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	public void service
	(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException {
		
		System.out.println("Hello World!");
		
	}

}
