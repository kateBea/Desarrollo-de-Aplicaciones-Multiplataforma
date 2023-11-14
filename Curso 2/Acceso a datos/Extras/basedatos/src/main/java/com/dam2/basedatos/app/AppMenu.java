package com.dam2.basedatos.app;



import java.util.ArrayList;
import java.util.Iterator;

import daw.com.Pantalla;
import daw.com.Teclado;

public class AppMenu {
	private ArrayList<MenuItem> opciones;
	
	public AppMenu ()
	{
		opciones = new ArrayList<MenuItem>();
	}

	public Iterator<MenuItem> getOpciones() {
		return opciones.iterator();
	}

	
	public boolean addOpcion (MenuItem opcion)
	{
		boolean insertado = false;
		if (!opciones.contains (opcion))
		{
			opciones.add(opcion);
			insertado = true;
		}
		return insertado;
	}
	
	public boolean removeOpcion(MenuItem opcion)
	{
		return opciones.remove(opcion);
	}
	
	public boolean evaluarOpcion (int opc)
	{
		boolean exito = false;

		MenuItem item = getOpcion (opc);
		
		if (item != null)
		{
			exito = true;
			item.getAction().execute();
		}
		
		
		return exito;
	}
	
	public void mostrarOpciones()
	{
		
		for (MenuItem opcion:opciones)
			Pantalla.escribirString("\n" + opcion.getOpcion() + " . " + opcion.getMensaje());	
		
	}
	
	public int leerOpcion()
	{
		int opc;
		
		do{
			opc =Teclado.leerInt("\nopcion"); 
		}while (!valorCorrecto(opc));
		
		return opc;
	}
	
	public boolean valorCorrecto (int opc)
	{
		boolean correcto = false;
		
		
		MenuItem item = getOpcion (opc);
		
		if (item != null)
			correcto = true;
		
		return correcto;
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
		boolean fin = false;
		
		MenuItem item = getOpcion (opc);
		
		if (item != null  && item.getOpcion() == 0)
			fin = true;
		
		return fin;
		
	}
	
	public MenuItem getOpcion (int opc)
	{
		MenuItem item = null;
		
		
		for (int i = 0; i < opciones.size() && item == null; i++)
			if (opciones.get(i).getOpcion() == opc)
				item = 	opciones.get(i);
		
		return item;
	}

}
