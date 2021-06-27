package it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixItTest {

	@Test
	public void when4El() {
		int[][] in = {
				{1}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.next(), is(1));
	}

	@Test
	public void whenFirstEmptyThenNext() {
		int[][] in = {
				{}, {1}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.next(), is(1));
	}

	@Test
	public void whenFirstEmptyThenHashNext() {
		int[][] in = {
				{}, {1}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.hasNext(), is(true));
	}

	@Test
	public void whenRowHasDiffSize() {
		int[][] in = {
				{1}, {2, 3}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
	}

	@Test
	public void whenFewEmpty() {
		int[][] in = {
				{1}, {}, {}, {}, {2}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
	}

	@Test
	public void whenEmpty() {
		int[][] in = {
				{}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.hasNext(), is(false));
	}

	@Test(expected = NoSuchElementException.class)
	public void whenEmptyThenNext() {
		int[][] in = {
				{}
		};
		MatrixIt it = new MatrixIt(in);
		it.next();
	}

	@Test
	public void whenMultiHashNext() {
		int[][] in = {
				{}, {1}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.hasNext(), is(true));
		assertThat(it.hasNext(), is(true));
	}

	@Test
	public void whenNoElements() {
		int[][] in = {{}, {}, {}};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.hasNext(), is(false));
	}

	@Test
	public void whenRowHasDiffSize1() {
		int[][] in = {
				{1, 2, 3, 4},
				{5, 6},
				{},
				{7, 8},
				{9, 10, 11}
		};
		MatrixIt it = new MatrixIt(in);
		assertThat(it.next(), is(1));
		assertThat(it.next(), is(2));
		assertThat(it.next(), is(3));
		assertThat(it.next(), is(4));
		assertThat(it.next(), is(5));
		assertThat(it.next(), is(6));
		assertThat(it.next(), is(7));
		assertThat(it.next(), is(8));
		assertThat(it.next(), is(9));
		assertThat(it.next(), is(10));
		assertThat(it.next(), is(11));
	}
}