package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread3;

public class ThreadMain3 {
	
	public static void main(String[] args) {
		
		MyThread3 myThread3 = new MyThread3();
		myThread3.setName("Thread3");
		myThread3.setPriority(7);
		myThread3.start();
		
	}

}
