package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jspiders.jdbc.object.Student;

public class SelectDemo5 {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String dburl = 
					"jdbc:mysql://localhost:3306/weja2";
	private static String user = "root";
	private static String password = "root";
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			connection = DriverManager.
					getConnection(dburl, user, password);
			
			statement = connection.createStatement();
			query = "select * from student";
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Student student = new Student();
				
				student.setSid(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setEmail(resultSet.getString(3));
				student.setContact(resultSet.getLong(4));
				
				System.out.println(student);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
