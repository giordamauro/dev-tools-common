package com.util.log;

public enum Task {

	ASSIST("assisted"), IMPLEMENT("implemented"), TEST("tested"), CHECK("checked"), REVIEW("reviewed"), CALL("participated in call"), DEPLOY("deployed"), UPLOAD("uploaded"), INVESTIGATE(
			"investigated"), MEETING("participated in a meeting"), HELP("helped");

	private String message;

	private Task(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
