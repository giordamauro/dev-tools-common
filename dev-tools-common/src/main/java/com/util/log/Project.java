package com.util.log;

public enum Project {

	LIVENATION(Plattform.FOUR_G);

	private Plattform plattform;

	private Project(Plattform plattform) {
		this.plattform = plattform;
	}

	public Plattform getPlattform() {
		return plattform;
	}

	public String toString() {
		return this.name() + "(" + plattform.getValue() + ")";
	}
}
