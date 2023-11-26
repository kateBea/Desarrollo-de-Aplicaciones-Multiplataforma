package org.dam2.banco.acciones;

import org.dam2.utilidadesmenu.MenuAction;

public class ListarDatos extends AccionBanco implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		cuentaDAO.findAll().forEach(System.out::println);
		clienteDAO.findAll().forEach(System.out::println);
	}

}
