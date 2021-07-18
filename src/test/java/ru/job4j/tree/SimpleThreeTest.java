package ru.job4j.tree;

import com.sun.source.tree.Tree;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleThreeTest {

	@Test
	public void when6ElFindLastThen6() {
		SimpleTree<Integer> tree = new SimpleTree<>(1);
		tree.add(1, 2);
		tree.add(1, 3);
		tree.add(1, 4);
		tree.add(4, 5);
		tree.add(5, 6);
		assertThat(
				tree.findBy(6).isPresent(),
				is(true)
		);
	}

	@Test
	public void when6ElFindNotExitThenOptionEmpty() {
		SimpleTree<Integer> tree = new SimpleTree<>(1);
		tree.add(1, 2);
		assertThat(
				tree.findBy(7).isPresent(),
				is(false)
		);
	}

	@Test
	public void whenChildExistOnLeafThenNotAdd() {
		SimpleTree<Integer> tree = new SimpleTree<>(1);
		tree.add(1, 2);
		tree.add(1, 3);
		tree.add(1, 4);
		tree.add(4, 5);
		tree.add(5, 6);
		assertFalse(tree.add(2, 6));
	}
}