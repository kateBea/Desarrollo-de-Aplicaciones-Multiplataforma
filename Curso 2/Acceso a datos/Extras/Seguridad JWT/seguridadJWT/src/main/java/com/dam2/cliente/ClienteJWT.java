package com.dam2.cliente;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dam2.modelo.Mensaje;

public class ClienteJWT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String token;
		
		token = validarCliente ();
		if (token != null)
			pedirMensajesConToken (token);
		else
			pedirMensajesSinToken ();
			//System.out.println("no hay token");
		

	}
	
	private static void pedirMensajesSinToken() {
		// TODO Auto-generated method stub
		final String URL = "http://localhost:8080/token/mensajes";
		RestTemplate restTemplate = new RestTemplate();
		Mensaje[] mensajes;
		ResponseEntity<Mensaje[]> response;
 		try
 		{
			response = restTemplate.exchange (URL, HttpMethod.GET,null, Mensaje[].class);
			mensajes = response.getBody();
			Stream.of(mensajes).forEach(System.out::println);
 		}
 		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	public static void pedirMensajesConToken(String token) {
		// TODO Auto-generated method stub
		final String URL = "http://localhost:8080/token/mensajes";
		RestTemplate restTemplate = new RestTemplate();
		Mensaje[] mensajes;
		ResponseEntity<Mensaje[]> response;
		
		RestTemplateBuilder builder = new RestTemplateBuilder ();
		
		
		restTemplate = builder.defaultHeader("Authorization", token).build();
		
		/*
 		try
 		{
			response = restTemplate.exchange (URL, HttpMethod.GET, new HttpEntity<String>(createHeaders(token)), Mensaje[].class);
			mensajes = response.getBody();
			Stream.of(mensajes).forEach(System.out::println);
 		}
 		*/
		
		try 
		{
			response = restTemplate.getForEntity(URL, Mensaje[].class);
			mensajes = response.getBody();
			Stream.of(mensajes).forEach(System.out::println);
		}
 		
 		catch (Exception e)
		{
			e.printStackTrace();
		}
 		
	}

	private static HttpHeaders createHeaders(String token) {
		// TODO Auto-generated method stub
		HttpHeaders cabeceras = new HttpHeaders ();
		cabeceras.set( "Authorization", token ); // añadir token a la cabecera
		return cabeceras;
	}

	public static String validarCliente ()
	{
		final String URL = "http://localhost:8080/token?user={user}&password={password}";
		String token = null;
		RestTemplate restTemplate = new RestTemplate();
		Map <String,String> params = new HashMap <>();

		System.out.println("user");
		String user = new Scanner(System.in).nextLine();
		
		System.out.println("password");
		String password = new Scanner(System.in).nextLine();
		
		params.put("user", user);
		params.put("password", password);
		try {
			ResponseEntity<String> response = restTemplate.postForEntity(URL, null, String.class,user,password);
			token = response.getBody();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return token;
	}

}
