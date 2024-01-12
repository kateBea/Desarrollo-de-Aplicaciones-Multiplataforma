package com.example.demo.vistaylectura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Contacto;

import daw.com.Teclado;

public class LeerCliente {
	private Cliente cliente;

	public LeerCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void leerClave ()
	{
		cliente.setNif(Teclado.leerString("\nNIF :"));
	}
	
	public void leerRestoDatos()
	{
		Set<Contacto> contactos =  new HashSet<>();
		

		
		cliente.setNombre(Teclado.leerString("\nNombre :"));
		

		cliente.setAval(Teclado.leerFloat("\nAval :"));
			
		System.out.println("Contactos");
		
		do
		{
			Contacto c = new Contacto ();
			c.setTelefono(Teclado.leerString("\nTelefono :"));
			
			c.setProveedor(Teclado.leerString("\nProveedor "));
			contactos.add(c);
		}while (Teclado.leerString("\nMás contactos?(SN)").equalsIgnoreCase("S"));
		
		cliente.setTelefonos(contactos);

	}

}
