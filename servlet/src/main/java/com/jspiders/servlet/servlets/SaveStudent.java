package com.jspiders.servlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class SaveStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String[] courses = req.getParameterValues("course");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Student Info:</h1>");
		writer.println("<h2>" + name + "</h2>");
		writer.println("<h2>" + email + "</h2>");
		writer.println("<h2>Courses:</h2>");
		if (courses != null) {
			for (String course : courses) {
				writer.println("<h2>" + course + "</h2>");
			}
		} else {
			writer.println("<h2>Courses not available</h2>");
		}

	}

}
