package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Cuenta;
import com.example.demo.modelo.CuentaPersonal;
import com.example.demo.repository.CuentaRepository;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired private CuentaRepository daoCuenta;
	

	@Override
	public List<Cuenta> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuenta>) daoCuenta.findAll();
	}

	@Override
	public Optional<Cuenta> findByNcc(String ncc) {
		// TODO Auto-generated method stub
		return daoCuenta.findById(ncc);
	}

	@Override
	public boolean ingresarDinero(String ncc, float cantidad) {
		// TODO Auto-generated method stub
		boolean exito = false;
		Cuenta cuenta;
		
		
		Optional<Cuenta> cuentaOptional = findByNcc (ncc);
		
		if (cuentaOptional.isPresent())
		{
			cuenta = cuentaOptional.get();
			if (cuenta.getNcc().equals(ncc))
			{
				cuenta.ingresar(cantidad);
				daoCuenta.save(cuenta);
				exito = true;
			}
		}
		return exito;
	}

	@Override
	public float findSaldoTotal() {
		// TODO Auto-generated method stub
		return daoCuenta.findSaldoTotal();
	}

	@Override
	public Cliente findClienteMasRico() {
		// TODO Auto-generated method stub
		//[0] cliente
		//[1] saldo
		return (Cliente) daoCuenta.findClienteMasRico().get(0)[0];
	}

	@Override
	public float retirarDinero(String ncc, float cantidad) {
		// TODO Auto-generated method stub
		float exito = cantidad;
		
		Cuenta cuenta = findByNcc (ncc).orElse(new CuentaPersonal());
		
		if (cuenta.getNcc().equals(ncc))
		{
			if (cuenta.retirar(cantidad))
				daoCuenta.save(cuenta);
			else
				exito = cuenta.maximoNegativo();
		}
		else
			exito = 0;
		
		return exito;
	}
	
	@Override
	public float transferirDinero(String nccOrigen, String nccDestino, float cantidad) {
		// TODO Auto-generated method stub
		float exito = cantidad;
		
		Cuenta cuentaOrigen = findByNcc (nccOrigen).orElse(new CuentaPersonal());
		Cuenta cuentaDestino = findByNcc (nccDestino).orElse(new CuentaPersonal());
		
		if (cuentaOrigen.getNcc().equals(nccOrigen) &&
				cuentaDestino.getNcc().equals(nccDestino))
		{
			if (cuentaOrigen.transferir (cantidad))
			{
				
				cuentaDestino.ingresar(cantidad);
				daoCuenta.save(cuentaOrigen);
				daoCuenta.save(cuentaDestino);
		
			}
			else
				exito = cuentaOrigen.maximoNegativo();
		}
		else
			exito = 0;
		
		return exito;
		
	}

	@Override
	public boolean insert(Cuenta cuenta) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!daoCuenta.existsById(cuenta.getNcc()))
		{
			daoCuenta.save(cuenta);
			exito = true;
		}
		
		return exito;
	}

	@Override
	public boolean update(Cuenta cuenta) {
		// TODO Auto-generated method stub
		boolean exito = false;
		
		if (!daoCuenta.existsById(cuenta.getNcc()))
		{
			daoCuenta.save(cuenta);
			exito = true;
		}
		
		return exito;
	}



	

}
