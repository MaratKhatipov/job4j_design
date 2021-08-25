package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
	public static void packFiles(List<File> source, File target) {
		try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
			for (File file : source) {
				zip.putNextEntry(new ZipEntry(file.getPath()));
				try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
					zip.write(out.readAllBytes());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void packSingleFile(File source, File target) {
		try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
			zip.putNextEntry(new ZipEntry(source.getPath()));
			try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
				zip.write(out.readAllBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			throw new IllegalArgumentException(
					"All arguments are absent."
					+ "Usage java -jar pack.jar, "
					+ "-d - folder_directory, "
					+ "-e - exclude_file, "
					+ "-o - output_folder"
			);
		} else if (args.length == 1) {
			throw new IllegalArgumentException(
					"Exclude_file and output_older are absent"
					+ "Usage java -jar pack.jar, "
					+ "-d - folder_directory, "
					+ "-e - exclude_file, "
					+ "-o - output_folder"
			);
		} else if (args.length == 2) {
			throw new IllegalArgumentException(
					"Output is absent"
					+ "Usage java -jar pack.jar, "
					+ "-d - folder_directory, "
					+ "-e - exclude_file, "
					+ "-o - output_folder");
		}

		ArgsName zip = ArgsName.of(args);
		List<File> sourceMain = Search
				.search(Paths.get(zip.get("d")), p -> !p.toFile().getName().endsWith("e"))
				.stream()
				.map(Path::toFile)
				.collect(Collectors.toList());
		packFiles(sourceMain, new File(zip.get("o")));
	}
}
