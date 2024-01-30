package com.dam2.model.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dam2.model.entitys.Customer;





@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	// mostrar todos ordenados
	Iterable<Customer> findAll (Sort sort);
	
	// mostrar todos paginados
	 Page<Customer> findAll(Pageable pageable);
	
	 
	// Buscar por el atributo lastName
    List<Customer> findByLastName(String lastName);

    // Buscar por el atributo lastName ordenado
    List<Customer> findByLastName(String lastName, Sort sort);
    
    // Buscar por el atributo lastName paginado
    Page<Customer> findByLastName(String lastName, Pageable pageable);
    
    // Borrar por lastName
    List<Customer> deleteByLastName (String lastName);
    
    Customer findById(long id);
    
}