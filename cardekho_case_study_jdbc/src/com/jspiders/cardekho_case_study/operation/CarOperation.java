package com.jspiders.cardekho_case_study.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static ResultSet resultSet;
	private static Properties properties;
	private static String query;
	private final static String dburl = "jdbc:mysql://localhost:3306/weja2";
	private static FileInputStream file;
	private static final String filePath = "C:\\Users\\Dhananjay\\Desktop\\J2EE Workspaces\\WEJA2\\cardekho_case_study_jdbc\\resources\\db_info.properties";
	
	private static void openConnection() {
		try {
			file = new FileInputStream(filePath);
			properties = new Properties();
			properties.load(file);
			connection = DriverManager.
						getConnection(dburl, properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (result != 0) {
				result = 0;
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

	public void addCarDetails() {
		try {
			openConnection();
			query = "insert into car_details "
					+ "values (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			Scanner scanner = new Scanner(System.in);
			System.out.println("How many car details"
					+ " you want to add?");
			int choice = scanner.nextInt();
			for (int i = 1; i <= choice ; i++) {
				System.out.println("Enter the details "
						+ "for car " + i);
				
				Car car = new Car();
			
				try {
					System.out.print("Enter car id : ");
					car.setCar_id(scanner.nextInt());
					
					System.out.print("Enter car name : ");
					car.setName(scanner.next());
					
					System.out.print("Enter car brand : ");
					car.setBrand(scanner.next());
					
					System.out.print("Enter car fuel type : ");
					car.setFuel_type(scanner.next());
					
					System.out.print("Enter car price : ");
					car.setPrice(scanner.nextDouble());
					
					preparedStatement.setInt(1, car.getCar_id());
					preparedStatement.setString(2, car.getName());
					preparedStatement.setString(3, car.getBrand());
					preparedStatement.setString(4, car.getFuel_type());
					preparedStatement.setDouble(5, car.getPrice());
					
					try {
						result = preparedStatement.executeUpdate();
					} catch (SQLIntegrityConstraintViolationException e) {
						System.out.println("Entered ID already exists! "
								+ "Record not added!");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("Invalid input! "
							+ "Data not inserted!");
					break;
				}
				
				if (result != 0) {
					System.out.println("Car no. " + i + " added. ");
				}
			}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void removeCarDetails() {
		try {
			openConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchByName() {
		try {
			openConnection();
			query = "select * from car_details "
					+ "where name = ?";
			preparedStatement = connection.prepareStatement(query);
			System.out.print("Enter car name : ");
			Scanner scanner = new Scanner(System.in);
			preparedStatement.setString(1, scanner.next());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car = new Car();
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchByBrand() {
		try {
			openConnection();
			query = "select * from car_details "
					+ "where brand = ?";
			preparedStatement = connection.prepareStatement(query);
			System.out.print("Enter car brand : ");
			Scanner scanner = new Scanner(System.in);
			preparedStatement.setString(1, scanner.next());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car = new Car();
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchByFuelType() {
		try {
			openConnection();
			query = "select * from car_details "
					+ "where fuel_type = ?";
			preparedStatement = connection.prepareStatement(query);
			System.out.print("Enter car fuel_type : ");
			Scanner scanner = new Scanner(System.in);
			preparedStatement.setString(1, scanner.next());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car = new Car();
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public ResultSet getAllCarDetails() {
		try {
			openConnection();
			String query = "select * from car_details";
			PreparedStatement preparedStatement = 
					connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editCarDetails() {
		try {
			searchAllCars();
			openConnection();
			System.out.print("Select car id to update : ");
			Scanner scanner = new Scanner(System.in);
			Car car = new Car();
			car.setCar_id(scanner.nextInt());
			System.out.print("Select option to update : \n"
					+ "1. Name\n"
					+ "2. Brand\n"
					+ "3. Fuel Type\n"
					+ "4. Price");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				query = "update car_details "
						+ "set name = ? "
						+ "where car_id = " + car.getCar_id();
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Enter new car name : ");
				car.setName(scanner.next());
				preparedStatement.setString(1, car.getName());
				result = preparedStatement.executeUpdate();
				if (result != 0) {
					System.out.println("Car name updated. ");
				}
				break;
			
			case 2:
				query = "update car_details "
						+ "set brand = ? "
						+ "where car_id = " + car.getCar_id();
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Enter new car brand : ");
				car.setBrand(scanner.next());
				preparedStatement.setString(1, car.getBrand());
				result = preparedStatement.executeUpdate();
				if (result != 0) {
					System.out.println("Car brand updated. ");
				}
				break;
				
			case 3:
				query = "update car_details "
						+ "set fuel_type = ? "
						+ "where car_id = " + car.getCar_id();
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Enter new car fuel type : ");
				car.setFuel_type(scanner.next());
				preparedStatement.setString(1, car.getFuel_type());
				result = preparedStatement.executeUpdate();
				if (result != 0) {
					System.out.println("Car fuel type updated. ");
				}
				break;
				
			case 4:
				query = "update car_details "
						+ "set price = ? "
						+ "where car_id = " + car.getCar_id();
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Enter new car price : ");
				car.setPrice(scanner.nextDouble());
				preparedStatement.setDouble(1, car.getPrice());
				result = preparedStatement.executeUpdate();
				if (result != 0) {
					System.out.println("Car price updated. ");
				}
				break;

			default:
				System.out.println("Invalid choice. ");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchAllCars() {
		try {
			openConnection();
			resultSet = getAllCarDetails();
			while(resultSet.next()) {
				Car car = new Car();
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}	
	}
	
}
