package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListUtilsTest {

	@Test
	public void whenAddBefore() {
		List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
		ListUtils.addBefore(input, 1, 2);
		assertThat(Arrays.asList(1, 2, 3), Is.is(input));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void whenAddBeforeWithInvalidIndex() {
		List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
		ListUtils.addBefore(input, 3, 2);
	}

	@Test
	public void whenAddAfterLast() {
		List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
		ListUtils.addAfter(input, 2, 3);
		assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
	}

	@Test
	public void whenRemoveIf() {
		List<Integer> input = new ArrayList<>(Arrays.asList(4, 5, 5, 5, 5, 4));
		ListUtils.removeIf(input, p -> p == 4);
		assertThat(Arrays.asList(5, 5, 5, 5, 4), Is.is(input));
	}

	@Test
	public void whenReplaceIf() {
		List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		ListUtils.replaceIf(input, p -> p == 1, 8);
		assertThat(Arrays.asList(8, 2, 3, 4), Is.is(input));
	}

	@Test
	public void whenRemoveAll() {
		List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2));
		ListUtils.removeAll(input, elements);
		assertThat(Arrays.asList(3, 4), Is.is(input));
	}
}