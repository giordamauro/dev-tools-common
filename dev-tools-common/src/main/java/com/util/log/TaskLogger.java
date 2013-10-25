package com.util.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.util.mail.MailUtils;

public class TaskLogger {

	private static final Log logger = LogFactory.getLog(TaskLogger.class);

	private static final String SEND_EMAIL_TO = "mgiorda@devspark.com";

	private static final String TASK_MAIL_SUBJECT = "-- Task Log --";

	public static void logTask(Object message) {

		String log = String.valueOf(message);

		logger.info(log);

		MailUtils.sendEmail(SEND_EMAIL_TO, TASK_MAIL_SUBJECT, log);

	}

	public static void main(String[] args) {

		JobTask task = JobTask.jira("Livenation 43 -> check password").addTasks(Task.TEST).setHours(3);

		logTask(task);
	}
}