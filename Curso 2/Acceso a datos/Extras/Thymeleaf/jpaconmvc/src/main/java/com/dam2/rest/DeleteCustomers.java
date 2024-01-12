package com.dam2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.model.entitys.Customer;
import com.dam2.model.service.ICustomerService;


@RestController
@RequestMapping (value="customers")
public class DeleteCustomers {
	@Autowired private ICustomerService service;
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomerbyId (@PathVariable Long id)
	{
		
		ResponseEntity<String>  response;
	

		
		if (service.deleteById(id))
			response = new ResponseEntity<>(HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return response;
	}
	
	
	
	@DeleteMapping("/delete/byname") // petición mediante un parámetro ../byname?name=Miguel
	public ResponseEntity<String> deleteCustomerByName(@RequestParam("name") String name)
	{
		
		ResponseEntity<String>  response;
	
		
		if (service.deleteByLastName(name).isEmpty())
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			response = new ResponseEntity<>(HttpStatus.OK);
		
		return response;
		
		
	}
}
