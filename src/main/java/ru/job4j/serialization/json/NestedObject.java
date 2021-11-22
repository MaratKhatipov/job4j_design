package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nested_object")
public class NestedObject {

	private String color;

	private int volume;

	public NestedObject() {
	}

	public NestedObject(String color, int volume) {
		this.color = color;
		this.volume = volume;
	}

	public String getColor() {
		return color;
	}

	public int getVolume() {
		return volume;
	}

	@Override
	public String toString() {
		return "NestedObject{"
				+ "color='" + color + '\''
				+ ", volume=" + volume + '}';
	}
}
