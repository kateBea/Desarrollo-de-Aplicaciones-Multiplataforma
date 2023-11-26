package org.dam2.banco.acciones;

import java.util.Set;
import java.util.stream.Collectors;

import org.dam2.banco.modelo.Cuenta;
import org.dam2.utilidadesmenu.MenuAction;

import daw.com.Teclado;

public class IngresarDinero extends AccionBanco implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		String ncc;
		float cantidad;
		Cuenta c;
	
		ncc = UtilidadesBanco.leerNCC();
		
		// pedir cantidad ingresar
		do
		{
			cantidad = Teclado.leerFloat("cantidad: ");
		}while (cantidad <= 0);
		
		// ingresar
		c = cuentaDAO.findById(ncc).get();
		c.ingresar(cantidad);
		
		// actualizar cuenta
		cuentaDAO.update(c);
		
	}

}
