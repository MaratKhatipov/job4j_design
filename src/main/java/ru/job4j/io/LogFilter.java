package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LogFilter {
	public static List<String> filter(String file) {
		List<String> result = new ArrayList<>();
		try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
			result = in.lines()
					.filter(lines -> lines.contains("404"))
					.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void save(List<String> log, String file) {
		try (PrintWriter out = new PrintWriter(
				new BufferedOutputStream(
						new FileOutputStream(file)
				))) {
			for (String  saveOut : log) {
				out.printf("%s%n", saveOut);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		List<String> log = filter("log.txt");
		System.out.println(log);
		save(log, "404.txt");
	}
}
