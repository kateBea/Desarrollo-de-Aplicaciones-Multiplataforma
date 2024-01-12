package com.dam2.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dam2.model.entitys.Customer;
import com.dam2.model.service.ICustomerService;

@RestController
@RequestMapping (value="customers")
public class GetCustomers {
	
	private ICustomerService service;

	// Inyección por constructor
	public GetCustomers (ICustomerService service)
	{
		this.service = service;
	}
	

	
	  
	@CrossOrigin//(origins = "http://localhost:9000")
	@GetMapping("/byid/{id}") // petición mediante el path ../byid/1
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id)
	{
		
		ResponseEntity <Customer> response;
		
		Customer customer = service.findById(id); 
		
		if (customer.getId() == 0)
			response =  new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		else
			response =  new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping("/byname") // petición mediante un parámetro ../byname?name=Miguel
	public List<Customer> getCustomerByName(@RequestParam("name") String name)
	{
		
		return service.findByLastName(name);
	}
	
	

}
