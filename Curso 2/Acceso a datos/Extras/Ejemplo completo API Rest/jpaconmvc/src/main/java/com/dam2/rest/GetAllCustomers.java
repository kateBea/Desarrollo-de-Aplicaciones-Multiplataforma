package com.dam2.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dam2.model.entitys.Customer;
import com.dam2.model.service.ICustomerService;

@RestController
@RequestMapping (value="customers")
public class GetAllCustomers {
	
	//@Autowired 
	private ICustomerService service;

	// Inyección por constructor
	public GetAllCustomers (ICustomerService service)
	{
		this.service = service;
		cargarDatos ();
	}
	
	private void cargarDatos ()
	{
		service.save(new Customer("Jack", "Bauer",LocalDate.now()));
        service.save(new Customer("Chloe", "O'Brian",LocalDate.now()));
        service.save(new Customer("Kim", "Bauer",LocalDate.now()));
        service.save(new Customer("David", "Palmer",LocalDate.now()));
        service.save(new Customer("Michelle", "Dessler",LocalDate.now()));
	}
	
	@GetMapping(value="all")
	public List<Customer> getAllCustomer()
	{
		
		return service.findAll();
	}
	
	@GetMapping(value="allordenados")
	public List<Customer> getAllCustomerSorted()
	{

		
		return service.findAllSorted();
	}
	
	@GetMapping(value="allpaginados")
	public List<Customer> getAllCustomerPaged()
	{

		
        // primera página de tamaño 2
		return service.findAllPaged(0, 2);
	}
	
	@GetMapping(value="allordenadosypaginados")
	public List<Customer> getAllCustomerSortedPaged()
	{

        // primera página de tamaño 2
		return service.findAllSortedPaged(0, 2);
	}

}
