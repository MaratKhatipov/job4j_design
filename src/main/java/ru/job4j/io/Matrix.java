package ru.job4j.io;

import java.io.FileOutputStream;

public class Matrix {
	public static void main(String[] args) {
		try (FileOutputStream out = new FileOutputStream("multiplication_table.txt")) {
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					out.write((i + "*" + j + " = " + i * j + System.lineSeparator()).getBytes());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}