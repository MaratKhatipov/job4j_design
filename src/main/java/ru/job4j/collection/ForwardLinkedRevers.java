package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinkedRevers<T> implements Iterable<T> {
	private Node<T> head;
	private Node<T> tail;

	public void addToEnd(T value) {
		Node<T> node = new Node<T>(value, null);
		if (head == null) {
			head = node;
			return;
		}
		tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = node;
	}

	public T deleteFirst() {
		if (head == null) {
			throw new NoSuchElementException();
		}
		T nodeRsl = head.value;
		head = head.next;
		return nodeRsl;
	}

	public void addFirst(T value) {
		Node<T> node = new Node<T>(value, null);
		if (head != null) {
			node.next = head;
		}
		head = node;
	}

	public boolean revert() {
		if (head == null) {
			return false;
		}
		if (head != null && head.next == null) {
			return false;
		}
		Node<T> currenNode = head.next;
		head.next = null;
		while (currenNode != null) {
			Node<T> next = currenNode.next;
			currenNode.next = head;
			head = currenNode;
			currenNode = next;
		}
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<>() {
			Node<T> node = head;

			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				T value = node.value;
				node = node.next;
				return value;
			}
		};
	}

	private static class Node<T> {
		T value;
		Node<T> next;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}
}
