package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.modelo.Cliente;
import com.example.demo.repository.ClienteRepository;


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
	public String findProveedorMasUsado() {
		// TODO Auto-generated method stub
		List<Object[]> listaProveedores = daoCliente.findProveedorMasUsado();
		
		return (String) listaProveedores.get(0)[0];
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
	public List<Cliente> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		
		return daoCliente.findByNombre(nombre);
	}


}
