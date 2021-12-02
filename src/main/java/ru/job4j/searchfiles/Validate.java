package ru.job4j.searchfiles;

/*
* Ключи
-d - директория, в которой начинать поиск.
-n - имя файла, маска, либо регулярное выражение.
-t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
-o - результат записать в файл.
* */

public class Validate {

	private final String directory;
	private final String fileName;
	private final String outFile;
	private final String typeSearch;

	public Validate(String[] args) {
		validate(4, args);
		ArgumentsName argsName = ArgumentsName.of(args);
		String directory = argsName.get("d");
		String fileName = argsName.get("n");
		String regularExp = argsName.get("t");
		String outFile = argsName.get("o");
		checkNull(directory);
		checkNull(fileName);
		checkNull(regularExp);
		checkNull(outFile);
		this.directory = directory;
		this.fileName = fileName;
		this.typeSearch = regularExp;
		this.outFile = outFile;
	}

	public String getDirectory() {
		return directory;
	}

	public String getSearchFile() {
		return fileName;
	}

	public String getOutFile() {
		return outFile;
	}

	public String getTypeSearch() {
		return typeSearch;
	}

	private void checkNull(String param) {
		if (param == null) {
			throw new IllegalArgumentException("аргумент отсутствует");
		}
	}

	private void validate(int length, String[] args) {
		if (args.length != length) {
			throw new IllegalArgumentException("не хватает аргументов");
		}
	}
}
