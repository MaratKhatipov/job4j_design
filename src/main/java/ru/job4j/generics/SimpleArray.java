package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
	private Object[] array;
	private int position = 0;

	public SimpleArray(int size) {
		this.array = new Object[size];
	}

	/**
	add(T model) - добавляет указанный элемент (model) в первую свободную ячейку;
	*/
	public void add(T model) {
		array[position] = model;
		position++;
	}
	/**
	set заменяет указанным элементом (model) элемент, находящийся по индексу index;
	 */
	public void set(int index, T model) {
		Objects.checkIndex(index, position);
			array[index] = model;
	}
	/**
	remove(int index) - удаляет элемент по указанному индексу,
	все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево
	(в середине массива не должно быть пустых ячеек);
	 */
	public void remove(int index) {
		Objects.checkIndex(index, position);
			System.arraycopy(array, index + 1, array, index, array.length - index - 1);
			position--;
			array[array.length - 1] = null;
		}
	/**
	get(int index) - возвращает элемент, расположенный по указанному индексу;
	 */
	public T get(int index) {
		T getResult = null;
		Objects.checkIndex(index, position);
		getResult = (T) array[index];
		return getResult;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			final private int check = position;
			private int pos = 0;

			@Override
			public boolean hasNext() {
				return pos < check;
			}

			@Override
			public T next() {
				T rsl = null;
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return rsl;
			}
		};
	}

	@Override
	public String toString() {
		return "SimpleArray{"
				+ "array=" + Arrays.toString(array)
				+ " array length = " + array.length + '}';
	}

	public static void main(String[] args) {
		SimpleArray<String> test = new SimpleArray<>(5);
		test.add("T model");
		test.add("hello");
		test.add("poka");
		test.add("Petr");
		test.add("Iliya");
		System.out.println(test);
		System.out.println(test.get(2));
		test.set(2, "999999999");
		System.out.println(test);
		test.remove(2);
		System.out.println(test);
	}
}