package com.metacube.get2019.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.get2019.service.impl.MockMailSender;
import com.metacube.get2019.service.impl.SMTPMailSender;

/**
 * This class defines the beans for the scenario
 * @author Kritika
 *
 */
@Configuration
public class MailSenderConfiguration {
	
	@Bean(name="mockmail")
	@Primary
	public MockMailSender getInstanceOfMockMailSender() {
		return new MockMailSender();
	}
	
	@Bean
	public SMTPMailSender getInstanceOfSmtpMailSender() {
		return new SMTPMailSender();
	}

}