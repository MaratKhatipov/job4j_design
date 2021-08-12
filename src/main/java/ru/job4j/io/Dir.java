package ru.job4j.io;

import java.io.File;
import java.util.Arrays;

public class Dir {
	public static void main(String[] args) {
		File file = new File("D:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\io");
		if (!file.exists()) {
			throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
		}
		if (!file.isDirectory()) {
			throw new IllegalArgumentException(String.format("Not directory", file.getAbsoluteFile()));
		}
		System.out.printf("size : %s%n", file.getTotalSpace());
		Arrays.stream(file.listFiles())
				.map(subFile -> "File name is: " + subFile.getName()
				+ "; File size = " + subFile.length() + "B")
				.forEach(System.out::println);
	}
}
