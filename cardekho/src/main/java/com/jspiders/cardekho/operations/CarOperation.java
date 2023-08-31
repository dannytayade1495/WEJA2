package com.jspiders.cardekho.operations;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.cardekho.entity.Car;

public class CarOperation {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("cardekho");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public void addCarDetails() {
		openConnection();
		
		System.out.println("How many cars you want to add?");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		for (int i = 1; i <= choice; i++) {
			transaction.begin();
			Car car = new Car();
			System.out.println("Enter the car name : ");
			car.setName(scanner.next());
			System.out.println("Enter the car brand : ");
			car.setBrand(scanner.next());
			System.out.println("Enter the fuel type : ");
			car.setFuel_type(scanner.next());
			System.out.println("Enter the car price : ");
			car.setPrice(scanner.nextDouble());
			manager.persist(car);
			transaction.commit();
		}
		
		closeConnection();
	}

	public void removeCarDetails() {
		List<Car> allCars = getAllCarDetails();
		
		openConnection();
		transaction.begin();
		
		System.out.println("ID \tName \tBrand \tFuel Type \tPrice\n"
				+ "===========================================");
		for (Car car : allCars) {
			System.out.println(car.getCar_id() + "\t"
					+ car.getName() + "\t"
					+ car.getBrand() + "\t"
					+ car.getFuel_type() + "\t"
					+ car.getPrice());
		}
		
		System.out.println("Enter the id to remove : ");
		Scanner scanner = new Scanner(System.in);
		Car car = manager.find(Car.class, scanner.nextInt());
		manager.remove(car);
		
		System.out.println("Car removed successfully. ");
		
		transaction.commit();
		closeConnection();
	}

	public void searchByName() {
		openConnection();
		transaction.begin();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the car name : ");
		jpql = "from Car where name = '" + scanner.next() + "'";
		query = manager.createQuery(jpql);
		List<Car> allCars = query.getResultList();
		
		System.out.println("ID \tName \tBrand \tFuel Type \tPrice\n"
				+ "===========================================");
		for (Car car : allCars) {
			System.out.println(car.getCar_id() + "\t"
					+ car.getName() + "\t"
					+ car.getBrand() + "\t"
					+ car.getFuel_type() + "\t"
					+ car.getPrice());
		}
		
		transaction.commit();
		closeConnection();
	}

	public void searchByBrand() {
		openConnection();
		transaction.begin();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the car brand : ");
		jpql = "from Car where brand = '" + scanner.next() + "'";
		query = manager.createQuery(jpql);
		List<Car> allCars = query.getResultList();
		
		System.out.println("ID \tName \tBrand \tFuel Type \tPrice\n"
				+ "===========================================");
		for (Car car : allCars) {
			System.out.println(car.getCar_id() + "\t"
					+ car.getName() + "\t"
					+ car.getBrand() + "\t"
					+ car.getFuel_type() + "\t"
					+ car.getPrice());
		}
		
		transaction.commit();
		closeConnection();
	}

	public void searchByFuelType() {
		openConnection();
		transaction.begin();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the car fuel type : ");
		jpql = "from Car where fuel_type = '" + scanner.next() + "'";
		query = manager.createQuery(jpql);
		List<Car> allCars = query.getResultList();
		
		System.out.println("ID \tName \tBrand \tFuel Type \tPrice\n"
				+ "===========================================");
		for (Car car : allCars) {
			System.out.println(car.getCar_id() + "\t"
					+ car.getName() + "\t"
					+ car.getBrand() + "\t"
					+ car.getFuel_type() + "\t"
					+ car.getPrice());
		}
		
		transaction.commit();
		closeConnection();
	}

	public List<Car> getAllCarDetails() {
		openConnection();
		transaction.begin();
		
		jpql = "from Car";
		query = manager.createQuery(jpql);
		List<Car> allCars = query.getResultList();
		
		transaction.commit();
		closeConnection();
		
		return allCars;
	}

	public void editCarDetails() {
		openConnection();
		transaction.begin();
		
		transaction.commit();
		closeConnection();
	}

	public void searchAllCars() {
		
		List<Car> allCars = getAllCarDetails();
		
		openConnection();
		transaction.begin();
		
		System.out.println("ID \tName \tBrand \tFuel Type \tPrice\n"
				+ "===========================================");
		for (Car car : allCars) {
			System.out.println(car.getCar_id() + "\t"
					+ car.getName() + "\t"
					+ car.getBrand() + "\t"
					+ car.getFuel_type() + "\t"
					+ car.getPrice());
		}
		
		transaction.commit();
		closeConnection();
	}
	
}
