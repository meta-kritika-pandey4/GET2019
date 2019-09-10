package com.metacube.get2019.service;
/**
 * interface of MailSender
 * @author Kritika
 *
 */
public interface MailSender {
	/**
	 * This method sends mail 
	 * @return String telling which type of mail sent
	 */
	 String sendMail();
}