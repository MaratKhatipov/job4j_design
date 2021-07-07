package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList<T> implements Iterable<T> {

	private Object[] container;
	private int capacity = 10; // ёмкость массива по умолчанию
	private int arrSize;
	private int modCount = 0;

	public T get(int index) {
		Objects.checkIndex(index, arrSize);
		return (T) container[index];
	}

	public MyArrayList(int arrSize) {
		this.container = new Object[arrSize];
	}

	public MyArrayList() {
		this.container = new Object[capacity];
	}

	public void add(T model) {
		if (arrSize >= container.length) {
			Object[] tmp = new Object[container.length * 2];
			System.arraycopy(container, 0, tmp, 0, arrSize);
			container = tmp;
		}
		container[arrSize++] = model;
		modCount++;
	}

	public int arraySize() {
		return arrSize;
	}

	public int arrayCapacity() {
		return container.length;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int expectedModCount = modCount;
			private int position = 0;

			@Override
			public boolean hasNext() {
				return position < arrSize;
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
				return (T) container[position++];
			}
		};
	}
}
