package ru.job4j.collection.set;

import ru.job4j.collection.MyArrayList;
import ru.job4j.generics.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
	private MyArrayList<T> set = new MyArrayList<>();
	private int size = 0;

	@Override
	public boolean add(T value) {
		if (!contains(value)) {
			set.add(value);
			size++;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(T value) {
		/*
		пройтись по set пока есть элементы
		и если по пути встретился элемент value
		вернуть true!
		 */
		while (set.iterator().hasNext()) {
			if (Objects.equals(set.iterator().next(), value)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		return set.iterator();
	}
}
