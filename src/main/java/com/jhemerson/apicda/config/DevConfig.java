package com.jhemerson.apicda.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jhemerson.apicda.services.BDService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private BDService dbservice;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@PostConstruct
	public boolean instanciaDB() {
		if(value.equals("create")) {
			this.dbservice.instanciaDB();
		}
		return false;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
