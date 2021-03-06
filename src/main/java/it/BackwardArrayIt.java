package it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator {
	private final int[] data;
	private int point = 0;

	public BackwardArrayIt(int[] data) {
		this.data = data;
	}

	@Override
	public boolean hasNext() {
		return point < data.length;
	}

	@Override
	public Object next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return data[data.length - 1 - point++];
	}

	public static void main(String[] args) {
		BackwardArrayIt example = new BackwardArrayIt(new int[] {1, 2, 3, 4, 5, 6, 7});
		for (int i = 0; i < new int[] {1, 2, 3, 4, 5, 6, 7}.length; i++) {
			System.out.println(example.next() + " has the following item? - " + example.hasNext());
		}
	}
}
