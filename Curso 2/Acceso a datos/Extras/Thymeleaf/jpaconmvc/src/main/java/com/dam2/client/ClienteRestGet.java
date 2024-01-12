package com.dam2.client;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.dam2.model.entitys.Customer;

public class ClienteRestGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		findById ();
		

		findByLastName ();
		
	}
	
	public static void findById ()
	{
		final String URL = "http://localhost:8080/customers/byid/";
		RestTemplate restTemplate = new RestTemplate();
		
		Long id = 1L;
		
		
		try 
		{
			ResponseEntity<Customer> response  = restTemplate.getForEntity(URL+"{id}", Customer.class,id);
		
			System.out.println(response.getBody());
			
		}
		
		catch(HttpClientErrorException e)
		{
			System.out.println ("id no encontrado");
		}
		
	}

	
	public static void findByLastName ()
	{
		final String URL = "http://localhost:8080/customers/byname?name={name}";
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		String lastName = "Bauer";
		
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("name", lastName);
		
		Customer[] response  = restTemplate.getForObject(URL, Customer[].class,params);
		
				
		Stream <Customer> customers = Stream.of(response);
		customers.forEach(System.out::println);
			
		
		
	}
}
