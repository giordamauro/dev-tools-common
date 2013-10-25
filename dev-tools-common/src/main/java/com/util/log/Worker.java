package com.util.log;

public enum Worker {

	EMILIANO("Emiliano Sanchez"), GASTON("Gaston Manoli"), JUAN("Juan Flores"), EMILIO("Emilio Corengia");

	private String fullName;

	private Worker(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}
}
