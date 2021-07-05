package ru.job4j.generic;

import java.util.HashMap;
import java.util.Map;

public final class MemStore<T extends Base> implements Store<T> {

	private final Map<String, T> memory = new HashMap<>();

	@Override
	public void add(T model) {
		memory.put(model.getId(), model);
	}

	@Override
	public boolean replace(String id, T model) {
		if (memory.containsKey(id)) {
			memory.replace(id, model);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		if (memory.containsKey(id)) {
			memory.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public T findById(String id) {
		if (memory.containsKey(id)) {
			return memory.get(id);
		}
		return null;
	}
}