package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

	@Test
	public void whenStringAndRemoveFirst() {
		SimpleArray<String> sArStr = new SimpleArray<>(3);
		sArStr.add("a");
		sArStr.add("b");
		sArStr.add("c");
		sArStr.remove(0);
		assertEquals(sArStr.get(0), "b");
	}

	@Test
	public void whenIntegerAndRemoveMiddle() {
		SimpleArray<Integer> sArInt = new SimpleArray<>(4);
		sArInt.add(2);
		sArInt.add(3);
		sArInt.remove(1);
		sArInt.add(4);
		assertThat(sArInt.get(1), is(4));
	}

	@Test
	public void whenCharAndSet() {
		SimpleArray<Character> sArChar = new SimpleArray<>(3);
		sArChar.add('a');
		sArChar.add('b');
		sArChar.add('c');
		sArChar.set(2, 'd');
		assertThat(sArChar.get(2), is('d'));
	}
}