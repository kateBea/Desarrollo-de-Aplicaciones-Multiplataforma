package org.dam2.utilidadesmenu;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppMenu {
	public static final int SALIR = 0;
	
	private Set<MenuItem> opciones;
	
	public AppMenu ()
	{
		opciones = new HashSet<MenuItem>();
		opciones.add(new Salir ()); // Añadir la opción de salir por defecto
	}

	public Set<MenuItem> getOpciones() {
		return opciones;
	}

	
	public boolean addOpcion (MenuItem opcion)
	{	
		return opciones.add(opcion);
	}
	
	public boolean removeOpcion(MenuItem opcion)
	{
		return opciones.remove(opcion);
	}
	
	public void evaluarOpcion (int opc)
	{
		getOpcion(opc).ifPresent(o -> o.getAction().doMenuAction());	
	}
	
	public void mostrarOpciones()
	{
		opciones.stream().
					map(opcion ->opcion.getOpcion() + " . " + opcion.getMensaje()).
					forEach(System.out::println);
		
	}
	
	public int leerOpcion()
	{
		int opc;
		
		do{
			opc =Teclado.leerInt("\nopcion"); 
		}while (getOpcion(opc).isEmpty());
		
		return opc;
	}
	
	
	public void run ()
	{
		int opc;
		
		do
		{
			mostrarOpciones ();
			opc = leerOpcion ();
			evaluarOpcion(opc);
		}while (!salir(opc));
		
	}
	
	public boolean salir (int opc)
	{
		return getOpcion(opc).filter(o -> o instanceof Salir).isPresent();
	}
	
	public Optional <MenuItem> getOpcion (int opc)
	{
		return opciones.stream().
						filter(o -> o.getOpcion() == opc).
						findFirst();
	}

}
