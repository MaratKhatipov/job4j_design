package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
	public static void main(String[] args) {
		try (FileInputStream in = new FileInputStream("even.txt")) {
			StringBuilder text = new StringBuilder();
			int read;
			while ((read = in.read()) != -1) {
				text.append((char) read);
			}
			String[] num = text.toString().split(System.lineSeparator());
			for (String n : num) {
				if (Integer.parseInt(n) % 2 == 0) {
					System.out.println(n + " - чётное число");
				} else {
					System.out.println(n + " - нечётёное число");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
