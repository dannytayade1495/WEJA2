package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread1;

public class ThreadMain1 {
	
	public static void main(String[] args) {
		
		MyThread1 myThread1 = new MyThread1();
		myThread1.start();
		
	}

}
