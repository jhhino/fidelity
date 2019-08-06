package com.hino.loyalty.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hino.loyalty.service.DBService;

@Configuration
@Profile("dev")
public class ProfileDevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}") //gets value for the key specified into application-dev.properties
	private String dbStrategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!"create".equals(dbStrategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		return true;
	}
}
