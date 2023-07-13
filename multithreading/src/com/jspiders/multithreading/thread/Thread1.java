package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Resource;

public class Thread1 extends Thread {
	
	Resource resource;
	
	public Thread1(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		synchronized (resource.res1) {
			System.out.println(getName() 
					+ " applied lock on " + resource.res1);
			synchronized (resource.res2) {
				System.out.println(getName() 
						+ " applied lock on " + resource.res2);
			}
			System.out.println(getName() + " released " + resource.res2);
		}
		System.out.println(getName() + " released " + resource.res1);
	}

}
