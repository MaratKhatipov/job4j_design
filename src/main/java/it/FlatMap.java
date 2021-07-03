package it;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Collections;
/*
В этом задании Вам нужно создать поведение flatMap.
 */
public class FlatMap<T> implements Iterator<T> {
	private final Iterator<Iterator<T>> data;
	private Iterator<T> cursor = Collections.emptyIterator();

	public FlatMap(Iterator<Iterator<T>> data) {
		this.data = data;
	}

	@Override
	public boolean hasNext() {
		while (data.hasNext() && !cursor.hasNext()) {
			cursor = data.next();
		}
		return cursor.hasNext();
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		return cursor.next();
	}

	public static void main(String[] args) {
		Iterator<Iterator<Integer>> data = List.of(
				List.of(1, 2).iterator(),
				List.of(4).iterator(),
				List.of(7).iterator()
		).iterator();
		FlatMap<Integer> flat = new FlatMap<>(data);
		while (flat.hasNext()) {
			System.out.println(flat.next());
		}
	}
}
