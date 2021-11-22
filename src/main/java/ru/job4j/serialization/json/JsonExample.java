package ru.job4j.serialization.json;

import java.util.Arrays;


public class JsonExample {

	private boolean permission;
	private int numb;
	private String something;
	private  NestedObject nestedObject;
	private int[] somethingNumb;

	public JsonExample(boolean permission, int numb, String something, NestedObject nestedObject, int... somethingNumb) {
		this.permission = permission;
		this.numb = numb;
		this.something = something;
		this.nestedObject = nestedObject;
		this.somethingNumb = somethingNumb;
	}

	public boolean isPermission() {
		return permission;
	}

	public int getNumb() {
		return numb;
	}

	public String getSomething() {
		return something;
	}

	public NestedObject getNestedObject() {
		return nestedObject;
	}

	public int[] getSomethingNumb() {
		return somethingNumb;
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
