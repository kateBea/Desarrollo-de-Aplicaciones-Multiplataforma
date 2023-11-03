package org.dam2.ejer3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.dam2.json.Empleado;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class LocalidadesAdapter extends TypeAdapter<Localidades>{
	

	@Override
	public void write(JsonWriter out, Localidades value) throws IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson ();

		
		// escribrir inicio objeto
		out.beginObject();
		
		// escribir clave localidad
		out.name("localidad");
		
		
		if (value.getLocalidad().size() > 1) // escribir array
		{
			out.beginArray();
			for (Localidad l : value.getLocalidad())
				out.jsonValue(gson.toJson(l));
			out.endArray();
		}
		else // escribir un sólo elemento
			out.jsonValue(gson.toJson(value.getLocalidad().get(0)));
		
		
		
		// escribir fin del objeto
		out.endObject();
		
	}

	@Override
	public Localidades read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		
		
		Localidades localidades = new Localidades ();
		Gson gson = new Gson ();
		
		//System.out.println(in.peek());
		// Consumir comienzo objeto {
		in.beginObject();
		//System.out.println(in.peek());
		// Consumir nombre localidad
		in.nextName();
		//System.out.println(in.peek());
		
		if (in.peek() == JsonToken.BEGIN_ARRAY) // si llega un array
		{
			// Consumir array
			
			Type  listaDeLocaliades = TypeToken.getParameterized(ArrayList.class, Localidad.class).getType();
			localidades.setLocalidad(gson.fromJson(in, listaDeLocaliades));
			
		}

		else //llega un elemento consumirlo
			localidades.getLocalidad().add(gson.fromJson(in, Localidad.class));
		
		
		// Consumir final objeto 
		in.endObject();
		
		return localidades;
	}

}
