package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private int modCount;

	@Override
	public void add(E value) {
		Node<E> previousElement = tail;
		Node<E> newElement = new Node<E>(previousElement, value, null);
		tail = newElement;
		if (previousElement == null) {
			head = newElement;
		} else {
			previousElement.next = newElement;
		}
		size++;
		modCount++;
	}

	@Override
	public E get(int index) {
		Objects.checkIndex(index, size);
		Node<E> getElement = head;
		for (int i = 0; i < index; i++) {
			getElement = getElement.next;

		}
		return getElement.element;
	}

	public int linkedListSize() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node<E> temp = head;
			private int expectedModCount = modCount;

			@Override
			public boolean hasNext() {
				return temp != null;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				if (expectedModCount != modCount) {
					throw new ConcurrentModificationException();
				}
				E value = temp.element;
				temp = temp.next;
				return value;
			}
		};
	}

	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}
}