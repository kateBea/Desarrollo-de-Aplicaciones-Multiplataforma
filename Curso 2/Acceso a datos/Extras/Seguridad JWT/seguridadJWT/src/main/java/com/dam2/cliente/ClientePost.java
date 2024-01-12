package com.dam2.cliente;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;


import com.dam2.modelo.Mensaje;

public class ClientePost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String URL = "http://localhost:8080/mensajes/post";
		RestTemplateBuilder builder;
		
		
		builder = new RestTemplateBuilder ();
		
		
		
		//RestTemplate restTemplate = new RestTemplate();
		
		//restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("client", "client"));
		
		RestTemplate restTemplate = builder.basicAuthentication("client", "client").build();
		
		try {
			Mensaje mensaje = new Mensaje (1,"Hola");
			restTemplate.postForObject( URL, mensaje, Mensaje.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
