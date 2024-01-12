package com.dam2.client;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.dam2.model.entitys.Customer;

public class ClientRestPost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		addCustomer ();
		addCustomerBis ();
		findByLastName();

	}
	
	public static void addCustomer ()
	{
		final String URL = "http://localhost:8080/customers/add";

		Customer respuesta;		
		Customer customer = Customer.builder().firstName("Miguel").
				lastName("Sutil").
				fechaNacimiento(LocalDate.now()).build();
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		try 
		{
			respuesta = restTemplate.postForObject( URL, customer, Customer.class);
			System.out.println(respuesta);
		
		}
		catch (HttpClientErrorException  e)
		{
			System.out.println("error " + e.getMessage());
		}
		
	}
	
	public static void addCustomerBis ()
	{
		final String URL = "http://localhost:8080/customers/add1";

		Customer respuesta;
		
		Customer customer = Customer.builder().firstName("Lucia").
				lastName("Sutil").
				fechaNacimiento(LocalDate.now()).build();;
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		respuesta = restTemplate.postForObject( URL, customer, Customer.class);
		
		
		System.out.println(respuesta);
		
		
	}

	public static void findByLastName ()
	{
		final String URL = "http://localhost:8080/customers/byname?name={name}";
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		String lastName = "Sutil";
		
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("name", lastName);
		
		Customer[] response  = restTemplate.getForObject(URL, Customer[].class,params);
		
				
		Stream <Customer> customers = Stream.of(response);
		customers.forEach(System.out::println);
			
		
		
	}
}
