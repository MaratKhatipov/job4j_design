package ru.job4j.map;

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
		if (count >= capacity * LOAD_FACTOR) {
			expand();
		}
		int h = hash(key);
		int index = indexFor(h);
		if (table[index] == null) {
				table[index] = new MapEntry<>(key, value);
				count++;
				modCount++;
				return true;
			} else if (table[h] != null) {
				return false;
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
		return (capacity - 1) & (hash ^ (hash >>> 16));
	}

	private void expand() {
		capacity *= 2;
		MapEntry<K, V>[] tmpTable = table;
		table = new MapEntry[capacity];
		count = 0;
		for (MapEntry<K, V>  mapEntry : tmpTable) {
			if (mapEntry == null) {
				continue;
			}
			put(mapEntry.key, mapEntry.value);
		}
		modCount++;
	}

	@Override
	public V get(K key) {
		int h = hash(key);
		int index = indexFor(h);
		MapEntry res = table[index];

		if (table[index] == null) {
			return null;
		}
		if (table[index].key.equals(key)) {
			return table[index].getValue();
		}
		return null;
	}

	public int size() {
		return capacity;
	}

	@Override
	public boolean remove(K key) {
		if (key == null) {
			return false;
		}
		int index = indexFor(hash(key));
		if (table[index] == null) {
			return false;
		}
		if (table[index].key.equals(key)) {
			table[index] = null;
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
			private int point = -1;
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

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
