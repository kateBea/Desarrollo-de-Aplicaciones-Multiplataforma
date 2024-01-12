package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Cuenta;



public interface ICuentaService {

	public boolean insert (Cuenta cuenta);
	
	public boolean update (Cuenta cuenta);
	
	public List<Cuenta> findAll ();
	
	public Optional<Cuenta> findByNcc (String ncc);
	
	public boolean ingresarDinero (String nccOrigen, float cantidad);
	
	public float findSaldoTotal ();
	
	public Cliente findClienteMasRico ();
	
	public float retirarDinero (String ncc, float cantidad);

	float transferirDinero(String nccOrigen, String nccDestino, float cantidad);
}
