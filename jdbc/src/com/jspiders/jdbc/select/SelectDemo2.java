package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo2 {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String driverPath = "com.mysql.cj.jdbc.Driver";
	private static String dburl = "jdbc:mysql://localhost:3306/"
								+ "weja2?user=root&password=root";
	private static String query;
	
	public static void main(String[] args) {
		try {
			//1. Load Driver class
			Class.forName(driverPath);
			
			//2. Open Connection
			connection = DriverManager.getConnection(dburl);
			
			//3. Create Statement
			statement = connection.createStatement();
			query = "select * from student";
			resultSet = statement.executeQuery(query);
			
			//4. Process the result
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " || "
								+ resultSet.getString(2));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//5. Close connection
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
