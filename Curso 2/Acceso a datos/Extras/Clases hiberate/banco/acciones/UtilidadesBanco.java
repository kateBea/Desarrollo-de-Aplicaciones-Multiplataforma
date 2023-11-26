package org.dam2.banco.acciones;

import java.util.Set;
import java.util.stream.Collectors;

import daw.com.Teclado;

public class UtilidadesBanco {
	
	public static String leerNCC ()
	{
		String ncc;
		
		Set<String> nccs;
		
		nccs = (Set<String>) AccionBanco.cuentaDAO.
				executeQueryNamed("listado ncc").
				collect(Collectors.toSet());
		
		// pedir cuenta
		do
		{
			//AccionBanco.cuentaDAO.findAll().forEach(c -> System.out.println(c.getNcc()));
			//cuentaDAO.executeQuery("SELECT c.ncc from Cuenta c").forEach(System.out::println);
			nccs.forEach(System.out::println);
			ncc = Teclado.leerString("\nNcc");
		}while (!nccs.contains(ncc));
		
		return ncc;
	}

}
