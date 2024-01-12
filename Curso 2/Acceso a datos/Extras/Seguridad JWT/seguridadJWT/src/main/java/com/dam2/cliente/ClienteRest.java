package com.dam2.cliente;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;


import com.dam2.modelo.User;

public class ClienteRest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String URL = "http://localhost:8080/mensajes";
		RestTemplate restTemplate = new RestTemplate();

		String cliente = new Scanner(System.in).nextLine();
		
		ResponseEntity<String> response = restTemplate.exchange (URL, HttpMethod.GET, new HttpEntity<String>(createHeaders(cliente, cliente)), String.class);
		//ResponseEntity<String> response  = restTemplate.getForEntity(URL, String.class);
		
		System.out.println(response.getBody());
		
		

	}
	
	public static HttpHeaders createHeaders(String username, String password){
		   return new HttpHeaders() {{
		         String auth = username + ":" + password;
		         byte[] encodedAuth = Base64.encodeBase64( 
		            auth.getBytes(Charset.forName("ISO-8859-1")) );
		         String authHeader = "Basic " + new String( encodedAuth );
		         set( "Authorization", authHeader );
		      }};
		}

	

}
