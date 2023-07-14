package com.jspiders.filehandling.operation;

import java.io.File;

public class FileInfo {

	public static void main(String[] args) {

		File file = new File("Demo.txt");
		if (file.exists()) {
			System.out.println(file.getName());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length());
			if (file.canWrite()) {
				System.out.println("File is writable");
			} else {
				System.out.println("File is not writable");
			}
			if (file.canRead()) {
				System.out.println("File is readable");
			} else {
				System.out.println("File is not readable");
			}
			if (file.canExecute()) {
				System.out.println("File is executable");
			} else {
				System.out.println("File is not executable");
			}
		} else {
			System.out.println("File does not exist");
		}

	}

}
