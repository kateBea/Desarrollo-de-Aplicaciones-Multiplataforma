package org.dam2.clientebanco;

import org.dam2.clientebanco.modelo.Cliente;
import org.dam2.clientebanco.modelo.Contacto;
import org.dam2.clientebanco.repository.ClienteRepository;
import org.dam2.clientebanco.service.ClienteServiceImpl;
import org.dam2.clientebanco.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class CargarDatosClienteApp implements CommandLineRunner{

	@Autowired IClienteService clienteService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Cargando datos ...");
		
		cargarDatos ();
		

	}

	private void cargarDatos() {
		// TODO Auto-generated method stub
		Cliente cliente1,cliente2;
		
		cliente1 = Cliente.builder().
					nif("001").
					nombre("miguel").
					aval(10000).
					telefono(new Contacto("605353350","orange")).
					build();
		
		cliente2 = Cliente.builder().
				nif("002").
				nombre("luis").
				aval(5000).
				telefono(new Contacto("00000999","movistar")).
				telefono(new Contacto("11111999","orange")).
				build();
				
		if ( clienteService.insert(cliente1) && 
				clienteService.insert(cliente2))
			System.out.println("Datos cargados correctamente");
		else
			System.out.println("error cargando datos");
	}

}
