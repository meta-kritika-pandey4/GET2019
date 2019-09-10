package com.metacube.get2019.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.get2019.service.MailSender;

/**
 * This class is for checking dependency injection by qualifier and bean configuration
 * @author Kritika
 *
 */

@RestController
public class QualifierDependencyInjection {
	private MailSender mailType;
	
	public  QualifierDependencyInjection(MailSender mailType) {
		super();
		this.mailType = mailType;
	}
	public MailSender getMailType() {
		return mailType;
	}
	
	@Autowired
	@Qualifier("mockmail")
	public void setMailType(MailSender mailType) {
		this.mailType = mailType;
	} 
	
	@RequestMapping("/sendMail4")
	public String sendMailController() {
		return mailType.sendMail();
	}
}