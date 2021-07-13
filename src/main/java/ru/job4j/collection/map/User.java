package ru.job4j.collection.map;

import java.util.*;

public class User {
	private String name;
	private int children;
	private Calendar birthday;

	public User(String name, int children, Calendar birthday) {
		this.name = name;
		this.children = children;
		this.birthday = birthday;
	}

	public static void main(String[] args) {
		Calendar birthday = new GregorianCalendar(2010, 07, 13);
		User firstUser = new User("Kolya", 3, birthday);
		User secondUser = new User("Kolya", 3, birthday);

		Map<User, Object> testMap = new HashMap<>();

		testMap.put(firstUser, new Object());
		testMap.put(secondUser, new Object());

		if (firstUser.equals(secondUser)) {
			System.out.println("КЛЮЧИ одинаковые");
		}

		for (User key : testMap.keySet()) {
			Object value = testMap.get(key);
			System.out.println(key + " : " + value);
		}

		System.out.println(firstUser.hashCode());
		System.out.println(secondUser.hashCode());
		System.out.println(testMap.hashCode());
	}
}
