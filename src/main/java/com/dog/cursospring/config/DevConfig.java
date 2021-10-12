package com.dog.cursospring.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dog.cursospring.services.DBService;
import com.dog.cursospring.services.EmailService;
import com.dog.cursospring.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;

	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		
		if(strategy.equals("create")) {
			dbService.instantiateTestDatabase();	
			return true;
		}else {
			return false;
		}
		
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
}
