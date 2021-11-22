package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		/* JSONObject из json-строки строки */
		JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

		/* JSONArray из ArrayList */
		List<String> list = new ArrayList<>();
		list.add("Student");
		list.add("Free");
		JSONArray jsonStatuses = new JSONArray(list);

		/* JSONObject напрямую методом put */

		final JsonExample test = new JsonExample(false, 45, "JsoN",
				new NestedObject("blue", 555), 15, 20);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("permission", test.isPermission());
		jsonObject.put("numb", test.getNumb());
		jsonObject.put("something", test.getSomething());
		jsonObject.put("nested_object", test.getNestedObject());
		jsonObject.put("somethingNumb", test.getSomethingNumb());

		/* Выведем результат в консоль */
		System.out.println(jsonObject.toString());

		System.out.println("+++++++++++++++++++++++++++++++++++");

		/* Преобразуем объект person в json-строку */
		System.out.println(new JSONObject(test).toString());
	}

}
