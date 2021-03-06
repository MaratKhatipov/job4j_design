package ru.job4j.iterator;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {
	public static <T> void addBefore(List<T> list, int index, T value) {
		Objects.checkIndex(index, list.size());
		ListIterator<T> i = list.listIterator();
		while (i.hasNext()) {
			if (i.nextIndex() == index) {
				i.add(value);
				break;
			}
			i.next();
		}
	}

	public static <T> void addAfter(List<T> list, int index, T value) {
		Objects.checkIndex(index, list.size());
		ListIterator<T> i = list.listIterator(list.size());
		while (i.hasPrevious()) {
			if (i.previousIndex() == index) {
				i.add(value);
				break;
			}
			i.next();
 		}
	}

	public static <T> void removeIf(List<T> list, Predicate<T> filter) {
		ListIterator<T> i = list.listIterator();
		while (i.hasNext()) {
			if (filter.test(i.next())) {
				i.remove();
				break;
			}
			i.next();
		}
	}

	public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
		ListIterator<T> i = list.listIterator();
		while (i.hasNext()) {
			if (filter.test(i.next())) {
				i.set(value);
			}
		}
	}

	public static <T> void removeAll(List<T> list, List<T> elements) {
		ListIterator<T> iterator = list.listIterator();
		while (iterator.hasNext()) {
				if (elements.contains(iterator.next())) {
					iterator.remove();
				}

		}
	}

}
