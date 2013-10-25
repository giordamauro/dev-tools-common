package com.util.log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobTask {

	private final Type type;

	private final String subject;

	private final List<Task> tasks = new ArrayList<Task>();

	private final List<Worker> coWorkers = new ArrayList<Worker>();

	private int hours = -1;

	private int ticketNumber = -1;

	private Project project;

	private Status status;

	private boolean billable = false;

	public JobTask(Type type, String subject) {
		this.type = type;
		this.subject = subject;
	}

	public Type getType() {
		return type;
	}

	public String getSubject() {
		return subject;
	}

	public JobTask addTasks(Task... tasks) {

		for (Task task : tasks) {
			this.tasks.add(task);
		}
		return this;
	}

	public JobTask addCoWorkers(Worker... workers) {

		for (Worker worker : workers) {
			this.coWorkers.add(worker);
		}
		return this;
	}

	public JobTask setHours(int hours) {
		this.hours = hours;
		return this;
	}

	public JobTask setProject(Project project) {
		this.project = project;
		return this;
	}

	public JobTask setTicketNumber(int number) {
		this.ticketNumber = number;
		return this;
	}

	public JobTask setStatus(Status status) {
		this.status = status;
		return this;
	}

	public JobTask setBillable(boolean value) {
		this.billable = value;
		return this;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isBillable() {
		return billable;
	}

	public List<Task> getTasks() {
		return Collections.unmodifiableList(tasks);
	}

	public List<Worker> getCoWorkers() {
		return Collections.unmodifiableList(coWorkers);
	}

	public int getHours() {
		return hours;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public Project getProject() {
		return project;
	}

	public String toString() {
		String legend = "";

		if (billable) {
			legend += "BILLABLE -> ";
		}

		if (status != null) {
			legend += status + " ";
		}

		if (type != Type.INTERNAL) {
			legend += type.getMessage() + " - ";
		}

		for (Task task : tasks) {
			legend += task.getMessage() + ", ";
		}
		if (!tasks.isEmpty()) {
			legend = legend.substring(0, legend.length() - 2);
		}

		legend += ": " + subject;

		if (project != null || ticketNumber != -1) {
			legend += " - ";
		}

		if (project != null) {
			legend += "Project: " + project;
		}

		if (ticketNumber != -1) {
			legend += " Ticket: #" + ticketNumber;
		}

		if (hours != -1) {
			legend += " | Time: " + hours + " hs.";
		}

		if (!coWorkers.isEmpty()) {

			legend += " | Co-workers: ";
			for (Worker worker : coWorkers) {
				legend += worker.getFullName() + ", ";
			}
			legend = legend.substring(0, legend.length() - 2);
		}

		return legend;
	}

	public static final JobTask intern(String subject) {
		return new JobTask(Type.INTERNAL, subject);
	}

	public static final JobTask jira(String subject) {
		return new JobTask(Type.JIRA, subject);
	}

	public static final JobTask salesforce(String subject) {
		return new JobTask(Type.SALESFORCE, subject);
	}
}