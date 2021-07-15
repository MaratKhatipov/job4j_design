package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
	private static final float LOAD_FACTOR = 0.75f;
	private int capacity = 8;
	private int count = 0;
	private int modCount = 0;
	private MapEntry<K, V>[] table = new MapEntry[capacity];

	@Override
	public boolean put(K key, V value) {
		int h = hash(key);
		if (count >= capacity * LOAD_FACTOR) {
			expand();
		} else {
			if (table[h] == null) {
				table[h] = new MapEntry<>(key, value);
				count++;
				modCount++;
				return true;
			} else if (table[h] != null) {
				return false;
			}
		}
		return false;
	}

	private int hash(K hashCode) {
		int h;
		if (hashCode == null) {
			return 0;
		} else {
			h = hashCode.hashCode();
			return (capacity - 1) & (h ^ (h >>> 16));
		}
	}

	private int indexFor(int hash) {
		return hash % capacity;
	}

	private void expand() {
		table = Arrays.copyOf(table, capacity * 2);
		capacity *= 2;
	}

	@Override
	public V get(K key) {
		int h = hash(key);
		if (table[h] != null) {
			return table[h].value;
		}
		return null;
	}
	public int size() {
		return capacity;
	}

	@Override
	public boolean remove(K key) {
		int h = hash(key);
		if (table[h] != null) {
			table[h] = null;
			count--;
			modCount++;
			return true;
		}
		return false;
	}

	@Override
	public Iterator<K> iterator() {
		return new Iterator<>() {
			private final int size = count;
			private final MapEntry<K, V>[] tempTable = table;
			private final int expectedModCount = modCount;
			private int point = 0;
			private int extracted = 0;

			@Override
			public boolean hasNext() {
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
				return extracted < size;
			}

			@Override
			public K next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				point++;
				while (tempTable[point] == null) {
					point++;
				}
				extracted++;
				return tempTable[point].key;
			}
		};
	}

	private static class MapEntry<K, V> {
		K key;
		V value;

		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}
}
