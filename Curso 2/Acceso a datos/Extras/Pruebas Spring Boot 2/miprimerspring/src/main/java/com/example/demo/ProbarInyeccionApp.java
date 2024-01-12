package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProbarInyeccionApp implements CommandLineRunner {
	@Autowired
	private ISaludar saludo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub		
		saludo.saludar("Mario");
	}
	
}
