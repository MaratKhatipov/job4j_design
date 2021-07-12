package ru.job4j.collection;

public class SimpleQueue<T> {
	private final SimpleStack<T> in = new SimpleStack<>();
	private final SimpleStack<T> out = new SimpleStack<>();
	private int inElementCount = 0;
	private int outElementCount = 0;

	public T poll() {
		if (outElementCount == 0) {
			while (inElementCount > 0)  {
				out.push(in.pop());
				inElementCount--;
				outElementCount++;
			}
		}
		outElementCount--;
		return out.pop();
	}

	public void push(T value) {
		in.push(value);
		inElementCount++;
	}


}
