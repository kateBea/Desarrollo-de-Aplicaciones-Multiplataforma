package com.dam2.client;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.dam2.model.entitys.Customer;

public class ClientRestPut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		updateCustomer ();
		
		findByLastName();

	}
	
	public static void updateCustomer ()
	{
		final String URL = "http://localhost:8080/customers/update";

				
		Customer customer = Customer.builder().firstName("Nieves").
				lastName("Sutil").
				fechaNacimiento(LocalDate.now()).build();
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		try 
		{
			// id debe existir para que sea actualización
			customer.setId(11L);	
			
			restTemplate.put(URL, customer);
			System.out.println("registro actualizado");
		
		}
		catch (HttpClientErrorException  e)
		{
			System.out.println("error " + e.getMessage());
		}
		
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
