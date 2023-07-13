package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo2 {

	public static void main(String[] args) {

		File file = new File("Demo.txt");
		if (file.exists()) {
			System.out.println("File already exists");
		} else {
			try {
				file.createNewFile();
				System.out.println("File is created.");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("File is not created");
			}
		}

	}

}
