package ru.job4j.io;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor<Path> {
	List<Path> searchList = new ArrayList<>();
	Predicate<Path> condition;

	public SearchFiles(Predicate<Path> condition) {
		this.condition = condition;
	}

	public List<Path> getPaths() {
		return searchList;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		if (condition.test(file)) {
			searchList.add(file);
		}
		return FileVisitResult.CONTINUE;
	}
}
