package ru.job4j.serialization.json;

public class NestedObject {
	private String color;
	private int volume;

	public NestedObject(String color, int volume) {
		this.color = color;
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "NestedObject{"
				+ "color='" + color + '\''
				+ ", volume=" + volume + '}';
	}
}
