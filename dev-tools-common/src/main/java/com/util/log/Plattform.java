package com.util.log;

public enum Plattform {
	THREE_EIGHT("3.8"), FOUR_G("4G");

	private String value;

	private Plattform(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
