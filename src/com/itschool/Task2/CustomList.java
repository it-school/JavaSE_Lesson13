package com.itschool.Task2;

import java.util.Arrays;

public class CustomList
{
	private int[] values = new int[0];
	/*
	 * массив, в котором будут храниться все значения
	 * */
	private int currentIndex = 0;
	/*
	 * самый максимальный размер массива , который заполнен реальными данными
	 * */

	@Override
	public String toString()
	{
		return "CustomList{" +
				"values=" + Arrays.toString(values) +
				'}';
	}

	public void add(int i)
	{
		ensureArraySize();// проверка: хватит ли нам текущего массива, чтобы вставить в него еще одно значение
		values[currentIndex++] = i;

	}

	private void ensureArraySize()
	{

		if (currentIndex + 1 > values.length) {
			values = Arrays.copyOf(values, 3 * values.length / 2 + 1);
		}

		/*
		 * в данном логическом выражение проверяется: хватит ли нам места
		 * если нет, то копируем массив в массив по больше.
		 * для расчета нужного размера использовалася формула 3x/2+1;
		 * */
	}

	public int get(int index)
	{
		if (index > currentIndex - 1 || index < 0) { throw new RuntimeException("index out of bound"); }
		return values[index];
		/*
		 * для получения нужного значения делаем все тоже самое,
		 * что и с обычным массивом.
		 * только проверяем индекс, который на присылают
		 * */
	}

	public void remove(int index)
	{
		System.arraycopy(values, index + 1, values, index, currentIndex - 1 - index);
		values[--currentIndex] = 0;
		System.out.println(Arrays.toString(values));
		/*
		 * для удаление также используется копирование,
		 * но здесь мы корируем две части одного массива в другой
		 * без учета удаляемой переменной.
		 * */
	}
}