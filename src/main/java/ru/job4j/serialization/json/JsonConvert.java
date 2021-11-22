package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class JsonConvert {

	public static void main(String[] args) throws JAXBException, IOException {

		final JsonExample jsonExample = new JsonExample(true, 45,
				"Hello",
				new NestedObject("Red", 45),  new int[]{1, 2, 3});

		/* Преобразуем объект person в json-строку. */
		final Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(jsonExample));

		/* Модифицируем json-строку */
		final String reverse =
				"{"
						+ "\"permission\":false,"
						+ "\"numb\":10,"
						+ "\"something\":\"Bye\","
						+ "\"nestedObject\":"
						+ "{"
						+ "\"color\":\"Red\","
						+ "\"volume\":45"
						+ "},"
						+ "\"somethingNumb\":[11, 22, 33]"
						+ "}";

		final JsonExample jsonReverse = gson.fromJson(reverse, JsonExample.class);
		System.out.println(jsonReverse);
	}
}
