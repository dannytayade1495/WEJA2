package com.jspiders.multithreading.thread;

public class MyThread3 extends Thread {
	
	@Override
	public void run() {
		System.out.println("Thread name : " + getName());
		System.out.println("Thread priority : " + this.getPriority());
	}

}
