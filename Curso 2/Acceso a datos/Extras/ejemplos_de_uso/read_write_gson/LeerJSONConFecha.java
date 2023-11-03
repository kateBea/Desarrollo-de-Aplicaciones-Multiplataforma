package org.dam2.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LeerJSONConFecha {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Leer de fichero
		
		EmpresaConFecha empresa;
		
		// poner adaptador de fechas
		GsonBuilder creadorGson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter());				
		Gson gson = creadorGson.create();
		
		//Gson gson = new Gson();
				
		Reader reader = new FileReader (new File ("empresaConFecha.json"));
				
		empresa = gson.fromJson(reader, EmpresaConFecha.class);
				
		reader.close();
				
		System.out.println(empresa);

	}

}
