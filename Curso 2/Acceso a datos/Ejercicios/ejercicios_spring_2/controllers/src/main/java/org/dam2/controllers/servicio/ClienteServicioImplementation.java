package org.dam2.controllers.servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.dam2.controllers.modelo.Cliente;
import org.dam2.controllers.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicioImplementation implements ClienteServicio {

	@Autowired
	ClienteRepositorio daoCliente;
	
	@Override
	public Optional<Cliente> findById(String nif) {
		// TODO Auto-generated method stub
		return daoCliente.findById(nif);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		// Requires Java 16 at leats, use collectors otherwise
		return StreamSupport.stream(daoCliente.findAll().spliterator(), false)
                .toList();
	}

	@Override
	public Optional<Cliente> insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		return Optional.of(daoCliente.save(cliente));
	}

	@Override
	public Optional<Cliente> actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return Optional.of(daoCliente.save(cliente));
	}

	@Override
	public boolean borrar(String nif) {
		daoCliente.deleteById(nif);
		 
		return daoCliente.existsById(nif);
	}
	
}
