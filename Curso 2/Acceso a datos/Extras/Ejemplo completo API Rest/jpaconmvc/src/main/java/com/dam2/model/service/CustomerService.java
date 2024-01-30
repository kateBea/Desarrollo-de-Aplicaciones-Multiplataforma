package com.dam2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.dam2.model.dao.CustomerRepository;
import com.dam2.model.entitys.Customer;
import com.dam2.model.service.ICustomerService;

@Service

public class CustomerService implements ICustomerService {

	@Autowired private	CustomerRepository daoCustomer;
	
	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return daoCustomer.save(customer);
		
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return (List<Customer>)daoCustomer.findAll();
	}

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return daoCustomer.findById(id).orElse(new Customer());
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return (List<Customer>)daoCustomer.findByLastName(lastName);
	}

	@Override
	public List<Customer> findAllSorted() {
		// TODO Auto-generated method stub
	
		Sort sort1 =  Sort.by("firstName").ascending();
		Sort sort2 = Sort.by("lastName").descending();
		Sort sort = sort1.and(sort2);
		
		return (List<Customer>) daoCustomer.findAll(sort);
	}

	@Override
	public List<Customer> findAllPaged(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		 PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		 
		 Page <Customer> page = daoCustomer.findAll(pageRequest);
		 
		return page.getContent();
	}

	@Override
	public List<Customer> findAllSortedPaged(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Sort sort1 =  Sort.by("firstName").ascending();
		
		
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort1);
		
		Page <Customer> page = daoCustomer.findAll(pageRequest);
		 
		return page.getContent();
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (daoCustomer.existsById(id))
		{
			daoCustomer.deleteById(id);
			exito = true;
		}
		
		return exito;
	}

	@Override
	@Transactional // anotar en funciones de borrado
	public List<Customer> deleteByLastName(String lastName) {
		// TODO Auto-generated method stub
		

		return daoCustomer.deleteByLastName(lastName);
		
	}

}
