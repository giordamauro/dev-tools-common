package com.util.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailUtils {

	private static final ApplicationContext mailContext = new ClassPathXmlApplicationContext("classpath:/mail-context.xml");

	public static void sendEmail(String to, String subject, String messageText) {

		Session session = mailContext.getBean(Session.class);
		InternetAddress from = mailContext.getBean(InternetAddress.class);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(from);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(messageText);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new IllegalStateException(e);
		}
	}

	public static void main(String[] args) {
		sendEmail("giordamauro@gmail.com", "Mi mensaje", "cuerpo");
	}
}
