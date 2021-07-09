package ru.job4j.collection;

public class SimpleQueue<T> {
	private final SimpleStack<T> in = new SimpleStack<>();
	private final SimpleStack<T> out = new SimpleStack<>();
	private int inElementCount = 0;
	private int outElementCount = 0;

	public T poll() {
		while (outElementCount <= inElementCount) {
			out.push(in.pop());
			inElementCount--;
			outElementCount++;
		}
		outElementCount--;
		return out.pop();
	}

	public void push(T value) {
		while (outElementCount > inElementCount) {
			in.push(out.pop());
			inElementCount++;
			outElementCount--;
		}
		in.push(value);
		inElementCount++;
	}


}
