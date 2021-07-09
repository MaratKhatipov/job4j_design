package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ForwardLinkedReversTest {

	@Test
	public void whenAddThenIter() {
		ForwardLinkedRevers<Integer> linked = new ForwardLinkedRevers<>();
		linked.addToEnd(1);
		linked.addToEnd(2);
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
	}

	@Test
	public void whenAddAndRevertThenIter() {
		ForwardLinkedRevers<Integer> linked = new ForwardLinkedRevers<>();
		linked.addToEnd(1);
		linked.addToEnd(2);
		linked.revert();
		Iterator<Integer> it = linked.iterator();
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(1));

	}

	@Test
	public void whenSize0ThenReturnFalse() {
		ForwardLinkedRevers<Integer> emptyList = new ForwardLinkedRevers<>();
		assertFalse(emptyList.revert());
	}

	@Test
	public void whenSize1ThenReturnFalse() {
		ForwardLinkedRevers<Integer> singleList = new ForwardLinkedRevers<>();
		singleList.addToEnd(1);
		assertFalse(singleList.revert());
	}

	@Test
	public void whenSize2ThenReturnTrue() {
		ForwardLinkedRevers<Integer> singleList = new ForwardLinkedRevers<>();
		singleList.addToEnd(1);
		singleList.addToEnd(2);
		assertTrue(singleList.revert());
	}
}