package org.dam2.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;

public class LeerJSONSinParser {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String claveElemento;
		JsonReader reader = new JsonReader (new FileReader ("empleados.json"));
		Empleado empleado;
		List <Empleado> empleados = new ArrayList<>(); 
		
		
		// Mostar tipo a leer
		System.out.println(reader.peek().name());
		// leer array
		reader.beginArray();
		
		
		
		while (reader.hasNext()) // Comprobar si el array tiene más elementos
		{
			// Mostar tipo a leer
			System.out.println(reader.peek().name());
			reader.beginObject(); // leer objeto del array
			
			
			empleado = new Empleado ();
			
			while (reader.hasNext()) // Comprobar si el objeto tiene más elementos
			{
				// Mostar tipo a leer
				System.out.println(reader.peek().name());
				
				claveElemento = reader.nextName(); // leer clave o nombre del elemento
				
			
				// Mostar tipo a leer
				System.out.println(reader.peek().name());
				// comprobar que elemento estamos leyendo y leer su contenido o valor
				switch (claveElemento)
				{
					case "id":
						empleado.setId(reader.nextString()); // leer elemento como String
						break;
					case "nombre":
						empleado.setNombre(reader.nextString()); // leer elemento como String
						break;
					case "dept":
						empleado.setDept(reader.nextString()); // leer elemento como String
						break;
					case "sueldo":
						empleado.setSueldo((float)reader.nextDouble()); //leer elemento como double
						break;
				}
				
			
			}
			
			empleados.add(empleado);
			// Mostar tipo a leer
			System.out.println(reader.peek().name());
			
			reader.endObject(); // fin del objeto
		}
		
		// Mostar tipo a leer
		System.out.println(reader.peek().name());
		reader.endArray(); // fin array
		
		System.out.println(empleados);
		
		// Cerrar flujo
		reader.close();

	}

}
