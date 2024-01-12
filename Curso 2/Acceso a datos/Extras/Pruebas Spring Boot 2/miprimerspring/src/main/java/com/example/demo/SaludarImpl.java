package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class SaludarImpl implements ISaludar {

	public SaludarImpl() {
		// Para depuración
		System.out.println("Construyendo objeto SaludarImpl");
	}
	
	@Override
	public void saludar(String nombre) {
		// TODO Auto-generated method stub
		System.out.println("Greetings " + nombre + "!");
	}

}
