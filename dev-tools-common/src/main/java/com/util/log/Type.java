package com.util.log;

public enum Type {

	SALESFORCE("Salesforce"), JIRA("Jira"), INTERNAL("");

	private String message;

	private Type(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
