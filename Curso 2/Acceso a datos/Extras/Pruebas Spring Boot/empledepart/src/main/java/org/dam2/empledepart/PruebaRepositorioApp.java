package org.dam2.empledepart;

import javax.persistence.TupleElement;

import org.dam2.empledepart.modelo.Emple;
import org.dam2.empledepart.repositorio.DeparRepository;
import org.dam2.empledepart.repositorio.EmpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PruebaRepositorioApp implements CommandLineRunner {

	@Autowired EmpleRepository daoEmple;
	@Autowired DeparRepository daoDepart;
	 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("listados..");
		//daoEmple.findAll().forEach(System.out::println);
		//daoDepart.findAll().forEach(System.out::println);
		//daoEmple.buscarNombreYSaldo().forEach(t -> System.out.println(t.get(0) + "->" + t.get(1)));
		//daoEmple.buscarNombreYSaldo().forEach(t -> System.out.println(t.get("nomemp") + "->" + t.get(1)));
		//daoEmple.buscarNombreYSaldo().forEach(t -> System.out.println(t.getNomemp() + "->" + t.getSalEmp()));
		//daoEmple.findByNomemp("Diana Solarte").forEach(System.out::println);
		
		/*
		Sort sort = Sort.by("salEmp").descending().and(Sort.by("nomemp"));
		daoEmple.findAll(sort).forEach(System.out::println);
		
		Pageable pageable = PageRequest.of(0, 5,sort);
		
		Page<Emple> page = daoEmple.findAll(pageable);
		
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(page.getNumber());
		System.out.println(page.hasNext());
		
		*/
		/*
		daoEmple.buscaTodos().forEach(e -> {e.setComisionE(0);System.out.println(e);});
		System.out.println("fin");
		*/
		/*
		daoEmple.findAll().forEach(System.out::println);
		System.out.println(daoEmple.modificarPorCargo(10,0));
		daoEmple.findAll().forEach(System.out::println);
		*/
		daoEmple.findAll().forEach(System.out::println);
		try {
			borrarEmpleados ();
		}
		catch (NullPointerException e)
		{
			System.out.println("transacción interrumpida");
		}
		daoEmple.findAll().forEach(System.out::println);
	}

	@Transactional
	public void borrarEmpleados() {
		// TODO Auto-generated method stub
		int n = -1;
		daoEmple.borrarEmpleado("333.333.335");
		
		if (n > 0)
			throw new NullPointerException();
		
		daoEmple.borrarEmpleado("1.130.555");
		
	}

}
