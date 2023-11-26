package org.dam2.banco; 

import org.dam2.banco.acciones.CargarDatos;
import org.dam2.banco.acciones.CrearCuenta;
import org.dam2.banco.acciones.HacerTransferencia;
import org.dam2.banco.acciones.IngresarDinero;
import org.dam2.banco.acciones.ListarDatos;
import org.dam2.banco.acciones.RealizarQuerys;
import org.dam2.utilidadesmenu.AppMenu;
import org.dam2.utilidadesmenu.MenuItem;

public class AppBancoConMenu extends AppMenu{

	public AppBancoConMenu ()
	{
		// Cargar opciones de menú
		addOpcion (new MenuItem("Crear Cuenta", 1, new CrearCuenta()));
		addOpcion (new MenuItem("Ingresar dinero", 2, new IngresarDinero()));
		addOpcion (new MenuItem("Realizar transferencia", 4, new HacerTransferencia()));
		addOpcion (new MenuItem("Realizar consultas", 6, new RealizarQuerys()));
		addOpcion (new MenuItem("Cargar datos de prueba", 7, new CargarDatos()));
		addOpcion (new MenuItem("Listar datos de prueba", 8, new ListarDatos()));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppBancoConMenu app = new AppBancoConMenu ();
		app.run();

	}

}
