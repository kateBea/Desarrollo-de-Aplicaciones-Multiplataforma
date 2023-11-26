package org.dam2.banco.acciones;

import java.util.ArrayList;
import java.util.HashSet;

import org.dam2.banco.modelo.Cliente;
import org.dam2.banco.modelo.Contacto;
import org.dam2.banco.modelo.Cuenta;
import org.dam2.banco.modelo.CuentaEmpresa;
import org.dam2.banco.modelo.CuentaPersonal;
import org.dam2.utilidadesmenu.MenuAction;

import daw.com.Teclado;

public class CrearCuenta extends AccionBanco implements MenuAction {

	private Cuenta cuenta;
	
	public CrearCuenta ()
	{
		cuenta = null;
	}
	
	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		
		// leer el tipo de cuenta a crear
		leerTipoCuenta ();
			
		// leer clientes
		leerClientes ();
		
		// leerDatosCuenta
		leerDatosCuenta ();
		
		// Mostrar cuenta leída
		System.out.println(cuenta);
		
		// insertar cuenta en BBDD
		cuentaDAO.save(cuenta);
		
		System.out.println("cuenta creada correctamente");
	}

	private void leerTipoCuenta() {
		// TODO Auto-generated method stub
		int tipo;
		
		do
		{
			tipo = Teclado.leerInt("tipo de cuenta (1. personal - 2. empresa)");
		}while (tipo != 1 && tipo != 2);

		cuenta = tipo== 1 ? new CuentaPersonal() : new CuentaEmpresa();
		
	}

	private void leerClientes() {
		// TODO Auto-generated method stub
		String nif;
		Cliente cliente;
		Contacto contacto;
		
		do
		{
			nif = Teclado.leerString("nif :");
			cliente = clienteDAO.findById(nif).orElse(new Cliente());
			if (cliente.getNif() == null)
			{
				cliente.setNif(nif);
				// Leer otros datos
				
				cliente.setNombre(Teclado.leerString("\nNombre :"));
				cliente.setAval(Teclado.leerFloat("Avales :"));
				do
				{
					contacto = leerContacto ();
					cliente.addContacto(contacto);
					
				}while (Teclado.leerString("Introducir otro contacto (S/N)?)").equalsIgnoreCase("s"));
				
			}
			cuenta.addCliente(cliente);
			
		}while (Teclado.leerString("Introducir otro cliente (S/N)?)").equalsIgnoreCase("s"));
		
	}

	private Contacto leerContacto() {
		// TODO Auto-generated method stub
		Contacto c;
		String telefono;
		
		do
		{
			telefono = Teclado.leerString("\nTeléfono contacto: ");
		}while (contactoDAO.findById(telefono).isPresent());
		
		c = new Contacto (telefono);
		
		c.setProveedor(Teclado.leerString("\nEmpresa Telelcomunicaciones: "));
		
		return c;
	}

	private void leerDatosCuenta() {
		// TODO Auto-generated method stub
		String ncc;
		float saldo;
		
		
		do
		{
			ncc = Teclado.leerString("\nNCC :");
		}while (cuentaDAO.findById(ncc).isPresent());
		
		cuenta.setNcc(ncc);
		do
		{
			saldo = Teclado.leerFloat("saldo :");
		}while (saldo <0);
		
		cuenta.setSaldo(saldo);
		
		// leer datos espécificos del tipo de cuenta
	
		
		// Uso de Pattern Matching con if
		if (cuenta instanceof CuentaPersonal personal)
		{
			personal.setCredito(Teclado.leerString("\nTarjeta de crédito(S/N)").equalsIgnoreCase("s"));
		}
		else if (cuenta instanceof CuentaEmpresa empresa)
		{
			empresa.setCif(Teclado.leerString("\ncif :"));
			empresa.setNombre(Teclado.leerString("\nnombre :"));
			empresa.setLocal(Teclado.leerString("\ndispone de local propio(S/N)").equalsIgnoreCase("s"));
		}
		
		
		/*
		// Uso de Pattern Matching con switch
		// Sólo con java 17
		// activar enable preview features
		switch(cuenta)
		{
			case CuentaPersonal personal ->
				personal.setCredito(Teclado.leerString("\nTarjeta de crédito(S/N)").equalsIgnoreCase("s"));
			case CuentaEmpresa empresa ->
				{
					empresa.setCif(Teclado.leerString("\ncif :"));
					empresa.setNombre(Teclado.leerString("\nnombre :"));
					empresa.setLocal(Teclado.leerString("\ndispone de local propio(S/N)").equalsIgnoreCase("s"));
				}
			
			default -> System.out.println("Cuenta no permitida");
			
		}
			
		*/
		
	}
	
	

}
