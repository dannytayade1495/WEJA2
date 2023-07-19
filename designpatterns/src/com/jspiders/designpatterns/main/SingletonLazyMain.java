package com.jspiders.designpatterns.main;

import com.jspiders.designpatterns.creational.SingletonLazy;

public class SingletonLazyMain {

	public static void main(String[] args) {

		SingletonLazy singletonLazy1 = SingletonLazy.getObject();
		System.out.println(singletonLazy1);
		SingletonLazy singletonLazy2 = SingletonLazy.getObject();
		System.out.println(singletonLazy2);
		SingletonLazy singletonLazy3 = SingletonLazy.getObject();
		System.out.println(singletonLazy3);

	}

}
