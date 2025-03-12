package com.jhemerson.apicda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//Anotação component - ela especifica que a classe está no contexto do spring fazendo com que seja gerada e inetada ao rodar
// Ela funciona exatamente como as anotações @Service e @Controller, na verdade essas duas ´herdam´e tem todas as caracteísticas  de @Component
@Configuration
public class BeanConfig {

    // Aqui eu tô definindo um Bean do tipo BCryptPasswordEncoder
    //Precisa ser feito pois é uma classe fora do contexto do seu projeto e do Spring
    //Quando fazemos isso eu to fazendo com que todos os BCryptPasswordEncoder com @Autowired tenham o valor abaixo injetadado automaticamente
    //No caso um objeto para todos que tiverem isso, e isso é a definição de um Bean
    @Bean
    public BCryptPasswordEncoder getEncoderBean(){
        return new BCryptPasswordEncoder();
    }
}
