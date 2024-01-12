package org.dam2.clientebanco.service;

import java.util.List;
import java.util.Optional;

import org.dam2.clientebanco.modelo.Cliente;
import org.dam2.clientebanco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired private ClienteRepository daoCliente;
	
	

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return  (List<Cliente>) daoCliente.findAll();
	}

	@Override
	public Optional<Cliente> findByNif(String nif) {
		// TODO Auto-generated method stub
		return daoCliente.findById(nif);
	}

	@Override
	public boolean insert(Cliente cliente) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!daoCliente.existsById(cliente.getNif()))
		{
			daoCliente.save(cliente);
			exito = true;
		}
		
		return exito;
	}

	@Override
	public boolean update(Cliente cliente) {
		// TODO Auto-generated method stub
		
		boolean exito = false;
		
		if (daoCliente.existsById(cliente.getNif()))
		{
			daoCliente.save(cliente);
			exito = true;
		}
		
		return exito;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (daoCliente.existsById(id))
		{
			daoCliente.deleteById(id);
			exito = true;
		}
		
		return exito;
	}

	@Override
	//@Transactional
	public int actulizarAval(String nif) {
		// TODO Auto-generated method stub
		
		/*
		int n=-11;
		daoCliente.modificaAval("001");
		if ( n > 0)
			throw new NullPointerException();
		daoCliente.modificaAval("002");
		*/
		
		return daoCliente.modificaAval(nif);
	}


}
