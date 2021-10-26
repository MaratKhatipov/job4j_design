package it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Создать итератор возвращающий только четные цифры.
Итератор должен принимать список произвольных чисел.
Iterator it = new EventIt(new int[] {4, 2, 1, 1});

методы
it.next() - возвращают только четные числа. В этом примере - это 4 и 2.
it.hasNext() - возвращает true, только если в массиве есть четные перед указателем.
 */
public class EvenNumbersIterator implements Iterator {
	private final int[] data;
	private int index = 0;

	public EvenNumbersIterator(int[] data) {
		this.data = data;
	}

	@Override
	public boolean hasNext() {
		while (index < data.length && data[index] % 2 != 0) {
			index++;
		}
		return index < data.length;
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return data[index++];
	}
}
