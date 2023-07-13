package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Pizza;

public class Friends extends Thread {
	
	private Pizza pizza;

	public Friends(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public void run() {
		pizza.orderPizza(5);
	}

}
