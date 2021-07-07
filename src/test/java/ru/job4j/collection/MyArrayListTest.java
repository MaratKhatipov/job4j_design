package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MyArrayListTest {

	@Test
	public void whenAddMore10() {
		MyArrayList<String> array = new MyArrayList<>();
		array.add("null");
		array.add("first");
		array.add("second");
		array.add("third");
		array.add("fourth ");
		array.add("fifth");
		array.add("sixth");
		array.add("seventh");
		array.add("eighth ");
		array.add("ninth ");
		array.add("tenth");
		array.add("chek");
		String rsl = array.get(11);
		assertThat(rsl, is("chek"));
	}

	@Test
	public void whenCapacity5() {
		MyArrayList<String> array = new MyArrayList<>(5);
		array.add("0");
		array.add("1");
		array.add("2");
		array.add("3");
		array.add("4 ");
		array.add("5");
		String rsl = array.get(5);
		assertThat(rsl, is("5"));
		assertThat(array.arraySize(), is(6));
		assertThat(array.arrayCapacity(), is(10));
	}


	@Test
	public void whenAddThenIt() {
		MyArrayList<String> array = new MyArrayList<>();
		array.add("first");
		String rsl = array.iterator().next();
		assertThat(rsl, is("first"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void whenGetEmpty() {
		MyArrayList<String> array = new MyArrayList<>();
		array.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void whenGetOutBound() {
		MyArrayList<String> array = new MyArrayList<>();
		array.add("first");
		array.get(1);
	}

	@Test(expected = NoSuchElementException.class)
	public void whenGetEmptyFromIt() {
		MyArrayList<String> array = new MyArrayList<>();
		array.iterator().next();
	}

	@Test(expected = ConcurrentModificationException.class)
	public void whenCorruptedIt() {
		MyArrayList<String> array = new MyArrayList<>();
		array.add("first");
		Iterator<String> it = array.iterator();
		array.add("second");
		it.next();
	}

	@Test
	public void whenChekCapacityAndSize() {
		MyArrayList<String> array = new MyArrayList<>(5);
		array.add("0");
		array.add("1");
		array.add("2");
		array.add("3");
		array.add("4 ");
		array.add("5");
		assertThat(array.arrayCapacity(), is(10));
		assertThat(array.arraySize(), is(6));
	}
}