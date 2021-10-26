package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
	private final Map<String, String> value = new HashMap<>();

	public String get(String key) {
		return value.get(key);
	}

	private void parse(String[] args) {
		String[] keyValue;
		if (args.length == 0) {
			throw new IllegalArgumentException(
					"No arguments, please add an array with arguments!"
			);
		}
		for (String tmpArg : args) {
			if (!tmpArg.contains("=") || tmpArg.startsWith("=") || tmpArg.endsWith("=")) {
				throw new IllegalArgumentException(
						"Error! use the argument format KEY = VALUE"
				);
			}
			keyValue = tmpArg.split("=");
			String tmpKey = keyValue[0].substring(1);
			String tmpValue = keyValue[1];
			value.put(tmpKey, tmpValue);
			System.out.printf("добавлен КЛЮЧ = %s%n" + "добавлено ЗНАЧЕНИЕ = %s%n", tmpKey, tmpValue);
		}

	}

	public static ArgsName of(String[] args) {
		ArgsName names = new ArgsName();
		names.parse(args);
		return names;
	}

	public static void main(String[] args) {
		ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
		System.out.println(jvm.get("Xmx"));

		ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
		System.out.println(zip.get("out"));
	}
}
