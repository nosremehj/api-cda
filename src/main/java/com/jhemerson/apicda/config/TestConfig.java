package com.jhemerson.apicda.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jhemerson.apicda.services.BDService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// Eu não entendi muito bem essa classe de test
@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private BDService dbService;

	@PostConstruct
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
    //Em teoria isso deveria funcionar, mas acho que ele tava tentando gerar a dependencia do BDService primeiro e por isso dava pau
}
