package ru.job4j.searchfiles;

import java.util.HashMap;
import java.util.Map;

public class ArgumentsName {
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

	public static ArgumentsName of(String[] args) {
		ArgumentsName names = new ArgumentsName();
		names.parse(args);
		return names;
	}
}
