package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
	private final List<String> duplicates = new ArrayList<>();
	private final Set<FileProperty> set = new HashSet<>();

	public List<String> getDuplicates() {
		return duplicates;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		FileProperty fProp = new FileProperty(attrs.size(), file.getFileName().toString());

		if (!set.add(fProp)) {
			duplicates.add(file.getFileName().toString());
			System.out.println(
					"Найдены дубликаты: "
					+ " name - " + file
					+ "\t\n" + "size = " + fProp.getSize());
		}
		return FileVisitResult.CONTINUE;
	}

	public void countDuplicates() {
		Set<String> set1 = new HashSet<>(duplicates);
		set1.stream()
				.map(s -> s + " : " + Collections.frequency(duplicates, s))
				.forEach(System.out::println);
	}

}
