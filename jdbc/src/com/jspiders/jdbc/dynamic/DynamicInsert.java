package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DynamicInsert {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filePath = "C:\\Users\\Dhananjay"
			+ "\\Desktop\\J2EE Workspaces\\WEJA2\\jdbc"
			+ "\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		try {
			file = new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"), properties);
			
			query = "insert into stud_details "
					+ "values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "Veeru");
			preparedStatement.setString(3, "veeru@gmail.com");
			preparedStatement.setLong(4, 9856741023L);
			
			result = preparedStatement.executeUpdate();
			
			System.out.println("Query OK, " + result + 
								" row(s) affected.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (file != null) {
					file.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
