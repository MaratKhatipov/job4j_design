package ru.job4j.collection.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleLinkedListTest {

	@Test
	public void whenAddAndGet() {
		List<String> list = new SimpleLinkedList<>();
		list.add("first");
		list.add("second");
		list.get(1);
		assertThat(list.get(0), Is.is("first"));
		assertThat(list.get(1), Is.is("second"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void whenGetFromOutOfBoundThenExceptionThrown() {
		List<Integer> list = new SimpleLinkedList<>();
		list.add(1);
		list.add(2);
		list.get(2);
	}

	@Test
	public void whenGetIteratorTwiceThenEveryFromBegin() {
		List<Integer> list = new SimpleLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		Iterator<Integer> first = list.iterator();
		assertThat(first.hasNext(), Is.is(true));
		assertThat(first.next(), Is.is(1));
		assertThat(first.hasNext(), Is.is(true));
		assertThat(first.next(), Is.is(2));
		assertThat(first.hasNext(), Is.is(true));
		assertThat(first.next(), Is.is(3));
		assertThat(first.hasNext(), Is.is(true));
		assertThat(first.next(), Is.is(4));
		assertThat(first.hasNext(), Is.is(false));


		Iterator<Integer> second = list.iterator();
		assertThat(second.hasNext(), Is.is(true));
		assertThat(second.next(), Is.is(1));
		assertThat(second.hasNext(), Is.is(true));
		assertThat(second.next(), Is.is(2));
		assertThat(second.hasNext(), Is.is(true));
		assertThat(second.next(), Is.is(3));
	}
}