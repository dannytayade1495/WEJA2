package com.jspiders.multithreading.resource;

public class Pizza {
	
	private int availablePizza;
	
	public synchronized void orderPizza(int orderedPizza) {
		System.out.println("Trying to order " 
							+ orderedPizza + " pizzas.");
		if (availablePizza < orderedPizza) {
			System.out.println(orderedPizza + " pizzas not available. "
											+ "Please wait..!!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		availablePizza -= orderedPizza;
		System.out.println(orderedPizza + " pizzas delivered.");
		System.out.println(availablePizza + " pizzas available.");
	}
	
	public synchronized void bakePizza(int bakedPizza) {
		System.out.println("Baking " + bakedPizza + " pizzas.");
		availablePizza += bakedPizza;
		System.out.println(bakedPizza + " pizzas baked.");
		System.out.println(availablePizza + " pizzas available.");
		this.notify();
	}

}
