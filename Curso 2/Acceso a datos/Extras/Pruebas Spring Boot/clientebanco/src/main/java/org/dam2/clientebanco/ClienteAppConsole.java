package org.dam2.clientebanco;

import org.dam2.clientebanco.service.ClienteServiceImpl;
import org.dam2.clientebanco.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(value=2)
public class ClienteAppConsole implements CommandLineRunner {

	@Autowired IClienteService clienteService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("Listado de clientes en la BBDD");
		clienteService.findAll().forEach(System.out::println);
		
		clienteService.actulizarAval("002");
		
		
		System.out.println("Listado de clientes en la BBDD");
		clienteService.findAll().forEach(System.out::println);
	}
	


}
