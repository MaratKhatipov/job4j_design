package ru.job4j.io;

import java.io.*;

public class Analise {
	byte flag = 1;
	StringBuilder sb = new StringBuilder();
	public void unavailable(String source, String target) {
		try (BufferedReader in = new BufferedReader(new FileReader(source))) {
			in.lines().forEach(el -> {
				if ((el.startsWith("500") || el.startsWith("400")) && flag == 1) {
					flag = 0;
					sb.append(el.substring(4)).append(";");
				}
				if ((el.startsWith("200") || el.startsWith("300")) && flag == 0) {
					flag = 1;
					sb.append(el.substring(4)).append(";").append(System.lineSeparator());
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
			out.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
			out.println("15:01:30;15:02:32");
			out.println("15:10:30;23:12:32");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
