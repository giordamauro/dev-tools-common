package com.util.mail;

import java.util.Properties;

import javax.mail.Session;

import org.springframework.beans.factory.FactoryBean;

public class MailSessionFactoryBean implements FactoryBean<Session> {

	private final Properties properties;

	private final MailAuthenticator authenticator;

	public MailSessionFactoryBean(Properties properties, MailAuthenticator authenticator) {
		this.properties = properties;
		this.authenticator = authenticator;
	}

	@Override
	public Session getObject() throws Exception {
		return Session.getInstance(properties, authenticator);
	}

	@Override
	public Class<?> getObjectType() {
		return Session.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
