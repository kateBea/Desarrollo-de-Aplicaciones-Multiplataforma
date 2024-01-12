package com.dam2.model.service;

import java.util.List;

import com.dam2.model.entitys.Customer;

public interface ICustomerService {

	public Customer save (Customer customer);
	
	public List<Customer> findAll ();
	
	public List<Customer> findAllSorted ();
	
	public List<Customer> findAllPaged (int pageNumber, int pageSize);
	
	public List<Customer> findAllSortedPaged (int pageNumber, int pageSize);
	
	public Customer findById (Long id);
	
	public List<Customer> findByLastName (String lastName);
	
	public boolean deleteById (Long id);
	
	public List<Customer> deleteByLastName (String lastName);
}
