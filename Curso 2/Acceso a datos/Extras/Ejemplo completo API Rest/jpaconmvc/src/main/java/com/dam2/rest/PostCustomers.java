package com.dam2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.dam2.model.entitys.Customer;
import com.dam2.model.service.ICustomerService;

@RestController
@RequestMapping (value="customers")
public class PostCustomers {
	
	@Autowired private ICustomerService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) 
	{
		HttpStatus status = HttpStatus.CREATED;
		
	    // Comporar datos antes de insertar
		if (customer.getId() == 0)
			service.save(customer);
		else
			status = HttpStatus.BAD_REQUEST;
		
	    return new ResponseEntity(status);
	}
	
	@PostMapping("/add1")
	public Customer createCustomer1 (@RequestBody Customer customer) 
	{
	    
		return service.save(customer);
		
		
	}
		

}
