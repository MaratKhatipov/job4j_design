package ru.job4j.searchfiles;



import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

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
		Pattern pattern;
		try {
			Path start = Paths.get(String.valueOf(directory));
			if ("name".equals(typeSearch)) {
				list = Search.search(start, p -> p.toFile().getName().equals(searchFile));
			} else if ("mask".equals(typeSearch)) {
				searchFile = searchMask();
				pattern = Pattern.compile(searchFile);
				list = Search.search(start, p -> p.toFile().getName().matches(pattern.toString()));
			} else if ("regex".equals(typeSearch)) {
				pattern = Pattern.compile(searchFile);
				list = Search.search(start, p -> p.toFile().getName().matches(pattern.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String searchMask() {
		String mask = searchFile.replaceAll("\\*", ".\\*");
		mask = mask.replaceAll("\\?", ".\\?");
		return mask;
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

		Validate validate = new Validate(args);
		SearchFiles searchFiles = new SearchFiles(
				validate.getDirectory(), validate.getSearchFile(),
				validate.getOutFile(), validate.getTypeSearch()
		);
		searchFiles.save();
		System.out.println("_______");
	}
}
