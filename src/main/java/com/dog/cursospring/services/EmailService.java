package com.dog.cursospring.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.dog.cursospring.domain.Pedido;

public interface EmailService {

	void sendorderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage m);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);

}
