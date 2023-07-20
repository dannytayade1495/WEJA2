package com.jspiders.designpatterns.creational;

public class SingletonEager {

	private static SingletonEager singletonEager = new SingletonEager();

	private SingletonEager() {

		System.out.println("Constructor is accessed.");

	}

	public static SingletonEager getObject() {

		return singletonEager;

	}

}
