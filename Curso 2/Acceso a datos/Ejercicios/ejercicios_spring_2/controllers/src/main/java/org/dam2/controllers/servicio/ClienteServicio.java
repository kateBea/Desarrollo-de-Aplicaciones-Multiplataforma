package org.dam2.controllers.servicio;

import java.util.List;
import java.util.Optional;

import org.dam2.controllers.modelo.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteServicio {
	Optional<Cliente> 	findById (String nif);
	List<Cliente> 		findAll ();
	Optional<Cliente> 	insertar (Cliente cliente);
	Optional<Cliente>	actualizar (Cliente cliente);
	boolean				borrar(String nif);
	
}
