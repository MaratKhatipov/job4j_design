package ru.job4j.searchfiles;

import ru.job4j.io.Search;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SearchFiles {

	private final String directory;
	private String searchFile;
	private final String outFile;
	private final String typeSearch;
	private List<Path> list = new ArrayList<>();

	public SearchFiles(String directory, String searchFile, String outFile, String typeSearch) {
		this.directory = directory;
		this.searchFile = searchFile;
		this.outFile = outFile;
		this.typeSearch = typeSearch;
	}

	public void search() {
		try {
			Path start = Paths.get(String.valueOf(directory));
			if (typeSearch.contains("name")) {
				list = Search.search(start, p -> p.toFile().getPath().contains(searchFile));
			} else if (typeSearch.equals("mask")) {
				searchFile = searchMask();
				list = Search.search(start, p -> p.toFile().getPath().contains(searchFile));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String searchMask() {
		searchFile.replaceAll("\\*", ".*");
		searchFile.replaceAll("\\?", "\\w");
		return searchFile;
	}

	public void save() {
		search();
		try (PrintWriter out = new PrintWriter(
				new BufferedOutputStream(
						new FileOutputStream(outFile, true)))) {
			list.stream().map(p -> p.getFileName().toString()).forEach(out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Аргументы: \n"
				+ "-d=D:\\projects\\job4j_design \n"
				+ "-n=java \n"
				+ "-t=mask \n"
				+ "-o=D:\\projects\\job4j_design\\src\\main\\resources\\1.txt"
		);
		Validate validate = new Validate(args);
		SearchFiles searchFiles = new SearchFiles(
				validate.getDirectory(), validate.getSearchFile(),
				validate.getOutFile(), validate.getTypeSearch()
		);
		searchFiles.save();
		System.out.println("_______");
	}
}
