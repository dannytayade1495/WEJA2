package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamRead {

	public static void main(String[] args) throws IOException {

		File file = new File("Demo.txt");
		if (file.exists()) {
			FileReader fileReader = new FileReader(file);
			System.out.println(fileReader.read());
			System.out.println("Data is fetched from the file using FileReader");
			fileReader.close();
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			System.out.println("Data fetched from the file using Scanner");
			scanner.close();
		} else {
			System.out.println("File does not exist");
		}

	}

}
