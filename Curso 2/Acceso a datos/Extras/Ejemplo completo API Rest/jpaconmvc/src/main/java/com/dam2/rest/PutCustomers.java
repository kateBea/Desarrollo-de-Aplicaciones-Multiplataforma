package com.dam2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.model.entitys.Customer;
import com.dam2.model.service.ICustomerService;

@RestController
@RequestMapping (value="customers")
public class PutCustomers {
	
@Autowired private ICustomerService service;
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) 
	{
		HttpStatus status = HttpStatus.ACCEPTED;
		
	    // Comporar datos antes de insertar
		if (customer.getId() != 0)
			service.save(customer);
		else
			status = HttpStatus.BAD_REQUEST;
		
	    return new ResponseEntity(status);
	}
	


}
