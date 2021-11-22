package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "json_example")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlExample {

	@XmlAttribute
	private boolean permission;
	@XmlAttribute
	private int numb;
	@XmlAttribute
	private String something;
	@XmlElement
	private NestedObject nestedObject;
	@XmlElementWrapper(name = "somethingNumbs")
	@XmlElement(name = "somethingNumb")
	private int[] somethingNumb;

	public XmlExample() {
	}

	public XmlExample(boolean permission, int numb, String something, NestedObject nestedObject, int... somethingNumb) {
		this.permission = permission;
		this.numb = numb;
		this.something = something;
		this.nestedObject = nestedObject;
		this.somethingNumb = somethingNumb;
	}

	@Override
	public String toString() {
		return "JsonExample{"
				+ "permission=" + permission
				+ ", numb=" + numb
				+ ", something='" + something + '\''
				+ ", nestedObject=" + nestedObject
				+ ", somethingNumb=" + Arrays.toString(somethingNumb)
				+ '}';
	}

}
