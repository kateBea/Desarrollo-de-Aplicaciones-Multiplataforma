package org.dam2.ejer2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class AppEjer2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Type  listaDeCursos;
		List<Curso> cursos;
		
		GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();				
		
		// mostrar nulls al escribir json
		creadorGson.serializeNulls();
		
		// poner adaptador de TipoFormacion
		creadorGson.registerTypeAdapter(TipoFormacion.class, new TipoFormacionJSONAdapter());
		
		// poner adaptador de LocalDateTime
		creadorGson.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJSONAdapter());
		
		
		Gson gson = creadorGson.create();
				
						
		Reader reader = new FileReader (new File ("ejer2.json"));
		
		// No se puede hacer
		//cursos = gson.fromJson(reader, List<Profesor>.class);
		
		// Previo a gson 2.8
		// Heredando de clase abstracta TypeToken
		/*
		ListadoDeCursos claseHeredada = new ListadoDeCursos ();
		listaDeCursos = claseHeredada.getType();
		*/
		
		// Con Clase Anónima
		/*
		TypeToken<List<Curso>> claseAnonima = new TypeToken<List<Curso>>(){}; 
		listaDeCursos = claseAnonima.getType(); 
		*/
		
		// Válido a partir de gson 2.8
		listaDeCursos = TypeToken.getParameterized(List.class, Curso.class).getType();
		
		cursos = gson.fromJson(reader, listaDeCursos);
						
		reader.close();
		
		cursos.forEach(System.out::println);
		
		System.out.println(gson.toJson(cursos));

	}

}
