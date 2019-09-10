package com.metacube.get2019.service.impl;

import org.springframework.stereotype.Component;
import com.metacube.get2019.service.MailSender;


/**
 * Class implementing mail sender
 * @author Kritika
 *
 */
@Component
public class MockMailSender implements MailSender {
	
	@Override
	public String sendMail() {
		return "Mock mail sent";
	}
}