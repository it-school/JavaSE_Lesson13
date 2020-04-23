package com.itschool.Task3;

public class CustomMap<K, V>
{
	private final Entry<K, V>[] table = new Entry[16];
	/*
	 * задаем главный массив,
	 * в котором и будем хранить данные
	 * */

	public void put(K key, V value)
	{
		int newHash = newHashGenerator(key); //  генерируем "рандомное" значение, используя ключ
		int index = indexFor(newHash); //table.length - с учетом размера массива
		Entry<K, V> entry = table[index];
		if (entry == null) {
			Entry<K, V> newEntry = new Entry<K, V>(key, value, newHash, null);
			table[index] = newEntry;
			// просто кладем значение в ячейку, если оно null
		}

		//todo

		/*
		 * В качестве дз:
		 * реализуйте, чтобы добавлялись значения мапу,
		 * если она пришла в ячейку, а она занята.
		 * Это было обговорено в начале занятия.
		 *
		 * Подсказка:
		 * когда мы пришли в ячейку и видим, что она занята,
		 * то смотрим в nexEntry , если оно тоже занято,
		 * то смотрим уже этого Entry его nexEntry.
		 * И так по циклу пока не дойдем, что nexEntry = null.
		 * Тогда вписываем туда наше значение
		 * */
	}

	private int newHashGenerator(K key)
	{
		int hash = key.hashCode();
		hash = hash ^ hash >>> 20 ^ hash >>> 12;
		return hash ^ hash >>> 7 ^ hash >>> 3;
		//  генерируем рандомное значение, используя ключ. Здесь можете поэкспериментировать
	}

	private int indexFor(int newHash)
	{
		return newHash & (table.length - 1);
		/*
		 * испоьзуем побитовое И для получения нужного нам индекса
		 * */

	}

	private V get(K key)
	{
		// todo
		/*
		 * Также в качестве дз реализуйте get
		 * Делается также само, как и put
		 * */
		return null;
	}


	private class Entry<K, V>
	{
		private K key;
		private V value;
		private int hash; // просто числовое значение. не путайте с hash-кодом!
		private Entry<K, V> nexEntry; // следуещее Entry, которое идет после него

		public Entry(K key, V value, int hash, Entry<K, V> nexEntry)
		{
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.nexEntry = nexEntry;
		}

		@Override
		public String toString()
		{
			return "Entry{" +
					"key=" + key +
					", value=" + value +
					", hash=" + hash +
					", nexEntry=" + nexEntry +
					'}';
		}

		public K getKey()
		{

			return key;
		}

		public void setKey(K key)
		{
			this.key = key;
		}

		public V getValue()
		{
			return value;
		}

		public void setValue(V value)
		{
			this.value = value;
		}

		public int getHash()
		{
			return hash;
		}

		public void setHash(int hash)
		{
			this.hash = hash;
		}

		public Entry<K, V> getNexEntry()
		{
			return nexEntry;
		}

		public void setNexEntry(Entry<K, V> nexEntry)
		{
			this.nexEntry = nexEntry;
		}
	}
}