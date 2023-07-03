package com.jspiders.cardekho_case_study.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {

	private List<Car> cars = new ArrayList<Car>();

	public void addCarDetails() {
		System.out.println("How many car details you want to add? ");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		for (int i = 1; i <= choice; i++) {
			Car car = new Car();
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
			cars.add(car);
			System.out.println("\n\n" + car.getName() + " added..!! ");
		}
		getAllCarDetails();
	}

	public void removeCarDetails() {
		getAllCarDetails();
		if (cars.isEmpty() == false) {
			Car car1 = null;
			System.out.print("\nEnter car id to remove : ");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			for (Car car : cars) {
				if (car.getCar_id() == choice) {
					car1 = car;
				}
			}
			if (car1 != null) {
				cars.remove(car1);
				System.out.println(car1.getName() + " removed..!!");
			} else {
				System.out.println("Invalid choice. Try again..!!");
			}
		}
	}

	public void getAllCarDetails() {
		if (cars.isEmpty()) {
			System.out.println("No car details found..!!");
		} else {
			System.out.println("Total car details : " + cars.size());
			System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
			System.out.println("=======================================================");
			for (Car car : cars) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
						+ car.getFuel_type() + "\t\t" + car.getPrice());
			}
		}
	}

	public void searchByName() {
		if (cars.isEmpty()) {
			System.out.println("No car details found..!!");
		} else {
			System.out.print("Enter car name : ");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			List<Car> allCars = new ArrayList<Car>();
			for (Car car : cars) {
				if (car.getName().equalsIgnoreCase(name)) {
					allCars.add(car);
				}
			}
			System.out.println("Total car details : " + allCars.size());
			System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
			System.out.println("=======================================================");
			for (Car car : allCars) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
						+ car.getFuel_type() + "\t\t" + car.getPrice());
			}
		}
	}

	public void searchByBrand() {
		if (cars.isEmpty()) {
			System.out.println("No car details found..!!");
		} else {
			System.out.print("Enter car brand : ");
			Scanner scanner = new Scanner(System.in);
			String brand = scanner.next();
			List<Car> allCars = new ArrayList<Car>();
			for (Car car : cars) {
				if (car.getBrand().equalsIgnoreCase(brand)) {
					allCars.add(car);
				}
			}
			System.out.println("Total car details : " + allCars.size());
			System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
			System.out.println("=======================================================");
			for (Car car : allCars) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
						+ car.getFuel_type() + "\t\t" + car.getPrice());
			}
		}
	}

	public void searchByFuelType() {
		if (cars.isEmpty()) {
			System.out.println("No car details found..!!");
		} else {
			System.out.print("Enter car fuel type : ");
			Scanner scanner = new Scanner(System.in);
			String fuel_type = scanner.next();
			List<Car> allCars = new ArrayList<Car>();
			for (Car car : cars) {
				if (car.getFuel_type().equalsIgnoreCase(fuel_type)) {
					allCars.add(car);
				}
			}
			System.out.println("Total car details : " + allCars.size());
			System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
			System.out.println("=======================================================");
			for (Car car : allCars) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
						+ car.getFuel_type() + "\t\t" + car.getPrice());
			}
		}
	}

	public void editCarDetails() {
		getAllCarDetails();
		if (cars.isEmpty() == false) {
			System.out.print("Enter car id to update : ");
			Scanner scanner = new Scanner(System.in);
			int car_id = scanner.nextInt();
			for (Car car : cars) {
				if (car.getCar_id() == car_id) {
					System.out.print("Enter new car name : ");
					car.setName(scanner.next());
					System.out.print("Enter new car brand : ");
					car.setBrand(scanner.next());
					System.out.print("Enter new car fuel type : ");
					car.setFuel_type(scanner.next());
					System.out.print("Enter new car price : ");
					car.setPrice(scanner.nextDouble());
					System.out.println("Car details updated..!!");
				} 
			}
		}
	}
}
