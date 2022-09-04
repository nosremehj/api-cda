package com.jhemerson.apicda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jhemerson.apicda.services.BDService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private BDService dbService;

	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
}
