package com.metacube.get2019.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.metacube.get2019.service.MailSender;

//@Component("smtpMailSender")
@Component
@Primary
public class SMTPMailSender implements MailSender {
	
	@Override
	public String sendMail() {
		return "SMTP Mail send";
	}
}