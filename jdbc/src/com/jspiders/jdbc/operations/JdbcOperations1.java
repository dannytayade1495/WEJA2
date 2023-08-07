package com.jspiders.jdbc.operations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcOperations1 {
	
	private static Connection connection;
	private static Statement statement;
	private static int result;
	private static ResultSet resultSet;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filePath = "C:\\Users\\Dhananjay"
			+ "\\Desktop\\J2EE Workspaces\\WEJA2\\jdbc"
			+ "\\resources\\db_info.properties";
	private static String query;
	
	public static void main(String[] args) {
		
		// 1. Create a table
		try {
			openConnection();
			try {
			query = "create table stud_details "
					+ "(sid int(3) primary key, name varchar(50),"
					+ "email varchar(30), contact bigint(10))";
			result = statement.executeUpdate(query);
			System.out.println("Query OK, " + result 
					+ " row(s) affected.");
			} catch(SQLSyntaxErrorException e) {
				System.out.println("Table already exists!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
		//2. Insert 5 records
		try {
			openConnection();
			Scanner scanner = new Scanner(System.in);
			for (int i = 1; i <= 5; i++) {
				System.out.println("Enter id :");
				int sid = scanner.nextInt();
				System.out.println("Enter name :");
				String name = scanner.next();
				System.out.println("Enter email :");
				String email = scanner.next();
				System.out.println("Enter contact :");
				long contact = scanner.nextLong();
				
				query = "insert into stud_details "
						+ "values (" + sid + ",'"
						+ name + "','" + email + "'," + contact + ")";
				try {
					result = result + statement.executeUpdate(query);
				} catch (SQLIntegrityConstraintViolationException e) {
					System.out.println("Entered id already exists!"
							+ "\nRecord not inserted! Try again!");
				}
			}
			scanner.close();
			System.out.println("Query OK, " + result 
					+ " row(s) affected.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
		//3. Select all records
		try {
			openConnection();
			query = "select * from stud_details";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | "
						+ resultSet.getString(2) + " | "
						+ resultSet.getString(3) + " | "
						+ resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
		//4. Update 2 records
		
	}
	
	private static void openConnection() {
		try {
			file = new FileInputStream(filePath);
			properties.load(file);
			Class.forName(properties.getProperty("driverPath"));
			connection = DriverManager.getConnection
					(properties.getProperty("dburl"), properties);
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void closeConnection() {
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
			if (file != null) {
				file.close();
			}
			if (result != 0) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
