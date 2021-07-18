package ru.job4j.collection.map;

import java.util.Objects;

public class TaleOfHashCode {
	private int firstValue;
	private short secondValue;
	private String thirdValue;

	public TaleOfHashCode(int firstValue, short secondValue, String thirdValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.thirdValue = thirdValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TaleOfHashCode that = (TaleOfHashCode) o;
		return firstValue == that.firstValue && secondValue == that.secondValue && Objects.equals(thirdValue, that.thirdValue);
	}

	@Override
	public int hashCode() {
		int result = Integer.hashCode(firstValue);
		int has = thirdValue.hashCode();
		result = 31 * result + Short.hashCode(secondValue);
		result = 31 * result + has;
		return result;
	}
}
/*
1. Объявить переменную типа int с именем result и инициализировать ее
хеш-кодом "с" для первого значащего поля вашего объекта, как показано
в п. 2, а. (значащее поле означает поле,значение которого влияет на сравнение объектов на равенство.)

2. Для каждого из остальных значащих полей выполняйте следующее.

а. Вычислить хеш-код "с" типа int для такого поля.
• Если поле примитивного типа, вычислить Type. hashCode (f), где
Туре — упакованный примитивный класс, соответствующий типу f.
• Если поле представляет собой ссылку на объект, и метод equals этого
класса сравнивает поля путем рекурсивных вызовов equals, рекурсивно
вызвать hashCode для поля. Если требуется более сложное
сравнение, вычислить “каноническое представление” этого поля
и вызвать для него hashCode. Если значение поля — null, использовать
0 (или некоторую иную константу, но 0 — более традиционное
значение).
• Если поле представляет собой массив, рассмотрите его, как если
бы каждый значащий элемент был отдельным полем. То есть вычислить
хеш-код для каждого значащего элемента путем рекурсивного
применения этих правил и объединить эти значения так, как показано
в п. 2, б. Если в массиве нет значащих элементов, использовать константу, предпочтительнее — не 0. Если все элементы являются
значащими, воспользоваться Arrays. hashCode.

б. Объединить хеш-код "с", вычисленный в п. 2, а, с result следующим
образом:
result = 31 * result + с;
3. Вернуть result.
 Блох Джошуа Java. Эффективное программирование
 */