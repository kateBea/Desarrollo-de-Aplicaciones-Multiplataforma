package com.dam2.client;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.dam2.model.entitys.Customer;

public class ClientRestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		deleteById();
		
		deleteByName ();

	}
	
	public static void deleteById ()
	{
		final String URL = "http://localhost:8080/customers/delete/{id}";
		RestTemplate restTemplate = new RestTemplate();
		
		Long id = 1L;
		
		
		try 
		{
			restTemplate.delete(URL,id);
		
			System.out.println("borrado correctamente");
			
		}
		
		catch(HttpClientErrorException e)
		{
			
			System.out.println ("id no encontrado");
		}
		
	}
	
	public static void deleteByName ()
	{
		final String URL = "http://localhost:8080/customers/delete/byname?name={name}";
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		String lastName = "Bauer";
		
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("name", lastName);
		
	    try 
		{
			restTemplate.delete(URL, params);
		
			System.out.println("borrado correctamente los registros encontrados");
			
		}
		
		catch(HttpClientErrorException e)
		{
			System.out.println ("no se han encontrado registros a borrar");
		}
		
		
	}


}
