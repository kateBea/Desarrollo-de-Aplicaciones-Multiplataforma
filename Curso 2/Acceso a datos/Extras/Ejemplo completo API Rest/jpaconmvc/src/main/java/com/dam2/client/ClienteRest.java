package com.dam2.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dam2.model.entitys.Customer;

public class ClienteRest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String URL = "http://localhost:8080/customers/all";
		RestTemplate restTemplate = new RestTemplate();
		
		/*
		
		List<LinkedHashMap> emps = restTemplate.getForObject(URL, List.class);
		
		System.out.println(emps.size());
		for(LinkedHashMap map : emps)
			System.out.println("ID="+map.get("id")
						+",firstName="+map.get("firstName")+
						",lastName="+map.get("lastName"));
		*/

		/*
		ResponseEntity<String> response
		  = restTemplate.getForEntity(URL, String.class);
		
		System.out.println(response.getBody());
		*/
		
		ResponseEntity<Customer[]> response  = restTemplate.getForEntity(URL, Customer[].class);
		
		System.out.println("GET StatusCode = " + response.getStatusCode());
		System.out.println("GET Headers = " + response.getHeaders());
		
		
		Stream <Customer> customers = Stream.of(response.getBody());
		customers.forEach(System.out::println);
	
		

	}

}
