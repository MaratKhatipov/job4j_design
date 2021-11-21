package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nested_object")
public class NestedObject {

	@XmlElement
	private String color;
	@XmlElement
	private int volume;

	public NestedObject() {
	}

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
