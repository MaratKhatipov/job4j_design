package ru.job4j.collection;

public class SimpleStack<T> {
	private ForwardLinked<T> linked = new ForwardLinked<>();
	private int size;
/*
Метод pop() - должен возвращать значение и удалять его из коллекции.
 */
	public T pop() {
		return linked.deleteFirst();
	}
/*
Метод push(T value) - помещает значение в коллекцию.
 */
	public void push(T value) {
		linked.addFirst(value);
	}
}

/*
Примечание:
При реализации стека на основе списка используются операции добавления и удаления
с одного и того же конца. Например, можно сделать добавление в начало и удаление с начала.
Либо с другого конца, т.е. с хвоста списка.
В итоге мы получим тоже самое поведение.
 */
