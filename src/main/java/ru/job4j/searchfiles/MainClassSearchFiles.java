package ru.job4j.searchfiles;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class MainClassSearchFiles {

	private final String directory;
	private String searchFile;
	private final String outFile;
	private final String typeSearch;
	private List<Path> list = new ArrayList<>();

	public MainClassSearchFiles(String directory, String searchFile, String outFile, String typeSearch) {
		this.directory = directory;
		this.searchFile = searchFile;
		this.outFile = outFile;
		this.typeSearch = typeSearch;
	}

	public static Predicate<Path> predicate(String searchFile, String typeSearch) {
		Predicate<Path> predictor = null;
		Pattern pattern;
		try {
			if ("name".equals(typeSearch)) {
				String finalSearchFile = searchFile;
				predictor = p -> p.toFile().getName().equals(finalSearchFile);
			} else if ("mask".equals(typeSearch)) {
				String mask = searchFile.replaceAll("\\*", ".\\*");
				mask = mask.replaceAll("\\?", ".\\?");
				pattern = Pattern.compile(mask);
				predictor = p -> p.toFile().getName().matches(pattern.toString());
			} else if ("regex".equals(typeSearch)) {
				pattern = Pattern.compile(searchFile);
				predictor = p -> pattern.matcher(p.toFile().getName()).find();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return predictor;
	}

	private String searchMask() {
		String mask = searchFile.replaceAll("\\*", ".\\*");
		mask = mask.replaceAll("\\?", ".\\?");
		return mask;
	}

	public static  void save(Path target, List<Path> pathList) {
		try (PrintWriter out = new PrintWriter(
				new BufferedOutputStream(
						new FileOutputStream(target.toFile())))) {
			for (Path path :pathList) {
				out.println(path.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fileSearch(ArgumentsName argumentsName) throws IOException {
	Path root = Paths.get(argumentsName.get("d"));
	Path target = Paths.get(argumentsName.get("o"));
	String searchName = argumentsName.get("n");
	String typeSearch = argumentsName.get("t");

	SearchFiles searchFiles = new SearchFiles(predicate(searchName, typeSearch));
	Files.walkFileTree(root, searchFiles);
	save(target, searchFiles.searchList);
	}


	public static void main(String[] args) throws IOException {
		Validate validate = new Validate(args);

		ArgumentsName argName = ArgumentsName.of(args);

		fileSearch(argName);
		System.out.println("_______");
	}
}
