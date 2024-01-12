package com.dam2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
    public Finalizar finalizar() {
        return new Finalizar();
    }
	
	@Bean
    public Inicializar inicializar() {
        return new Inicializar();
    }

}
