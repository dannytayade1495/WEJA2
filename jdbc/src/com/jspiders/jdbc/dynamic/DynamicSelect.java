package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DynamicSelect {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
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
			
			query = "select *"
					+ " from student "
					+ "where sid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | "
						+ resultSet.getString(2) + " | "
						+ resultSet.getString(3) + " | "
						+ resultSet.getString(4));
			}
			
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
				if (resultSet != null) {
					resultSet.close();
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
