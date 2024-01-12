package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;



public interface IClienteService {


	public boolean insert (Cliente cliente);
	
	public boolean update (Cliente cliente);
	
	public boolean delete (String id);
	
	public List<Cliente> findAll ();
	
	public Optional <Cliente> findByNif (String nif);

		
	public String findProveedorMasUsado ();
	
	public List<Cliente> buscarPorNombre (String nombre);
	
	
}
