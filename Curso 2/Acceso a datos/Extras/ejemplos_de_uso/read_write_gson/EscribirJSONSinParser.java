package org.dam2.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonWriter;

public class EscribirJSONSinParser {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Empleado> empleados = cargarDatos();
		
		JsonWriter writer = new JsonWriter(new FileWriter("empleadosBis.json"));
		
		// Comienza el array
		writer.beginArray();
		for (Empleado e: empleados)
		{
			System.out.println(e);
			// Comienza un objeto
			writer.beginObject();
			
			// Elementos del objeto
			writer.name("id"); // clave id
			writer.value(e.getId()); // valor
			
			writer.name("nombre");
			writer.value(e.getNombre());
			
			writer.name("dept");
			writer.value(e.getDept());
			
			writer.name("sueldo");
			writer.value(e.getSueldo());
			
			
			// Finaliza un objeto
			writer.endObject();
		}
		
		// Final del array
		writer.endArray();
		
		// cerrar el writer, si no se cierra no hay fichero
		writer.close();
		

	}
	
	public static List<Empleado> cargarDatos ()
	{
		List<Empleado> empleados = new  ArrayList<>();
		
	
		
		empleados.add(new Empleado("001", "miguel", "lengua", 2000));
		
		empleados.add(new Empleado ("002", "juan", "infor", 30000));
	
		
		return empleados;
	}

}
