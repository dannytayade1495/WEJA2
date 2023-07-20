package com.jspiders.designpatterns.creational;

import java.util.Scanner;

public class TeaFactory {

	private static Beverage beverage;

	public static void main(String[] args) {

		try {
			factory().order();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	public static Beverage factory() {

		System.out.println("Select tea to order");
		System.out.println("1. Normal tea\n" + "2. Black tea\n" + "3. Green tea\n" + "4. Ice tea");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		switch (choice) {
		case 1:
			beverage = new NormalTea();
			break;
		case 2:
			beverage = new BlackTea();
			break;
		case 3:
			beverage = new GreenTea();
			break;
		case 4:
			beverage = new IceTea();
			break;
		default:
			System.out.println("Invalid choice.");
			System.out.println("No tea ordered.");
		}

		return beverage;

	}

}
