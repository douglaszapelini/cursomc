package com.dog.cursospring.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService{

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger log = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage m) {
		log.info("Simulando envio de email...");
		mailSender.send(m);
		log.info("Email enviado!!");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		log.info("Simulando envio de email HTML...");
		javaMailSender.send(msg);
		log.info("Email enviado!!");
	}

}
