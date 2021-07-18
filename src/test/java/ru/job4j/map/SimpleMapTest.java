package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

	@Test
	public void whenPut2DifferentElementTrue() {
		SimpleMap testMap = new SimpleMap();
		assertTrue(testMap.put("one", 1));
		assertTrue(testMap.put("two", 2));
	}

	@Test
	public void whenPut2SameElementFalse() {
		SimpleMap testMap = new SimpleMap();
		assertTrue(testMap.put("one", 1));
		assertFalse(testMap.put("one", 1));
	}

	@Test
	public void whenNotPlace() {
		SimpleMap testMap = new SimpleMap();
		assertTrue(testMap.put("one", 1));
		assertFalse(testMap.put("четыре", 4));
	}

	@Test
	public void whenGetReturnValue() {
		SimpleMap testMap = new SimpleMap();
		testMap.put("one", 1);
		testMap.put("two", 2);
		assertThat(1, is(testMap.get("one")));
	}

	@Test
	public void whenGetReturnNull() {
		SimpleMap testMap = new SimpleMap();
		testMap.put("one", 1);
		testMap.put("четыре", 4);
		assertThat(null, is(testMap.get("two")));
	}

	@Test
	public void remove() {
		SimpleMap testMap = new SimpleMap();
		testMap.put("one", 1);
		testMap.put("two", 2);
		assertTrue(testMap.remove("one"));
		assertTrue(testMap.remove("two"));
		assertFalse(testMap.remove("NULL"));
	}

}