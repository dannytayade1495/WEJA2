package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Resource;
import com.jspiders.multithreading.thread.Thread1;
import com.jspiders.multithreading.thread.Thread2;

public class Deadlock {
	
	public static void main(String[] args) {
		Resource resource = new Resource();
		Thread1 thread1 = new Thread1(resource);
		Thread2 thread2 = new Thread2(resource);
		
		thread1.setName("T1");
		thread2.setName("T2");
		
		thread1.start();
		thread2.start();
		
	}

}
