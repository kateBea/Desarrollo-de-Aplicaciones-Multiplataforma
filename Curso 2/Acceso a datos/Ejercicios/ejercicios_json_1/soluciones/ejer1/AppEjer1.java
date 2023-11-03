package org.dam2.ejer1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.dam2.ejer3.Ejer3;
import org.dam2.ejer3.Localidades;
import org.dam2.ejer3.LocalidadesAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AppEjer1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		GsonBuilder creadorGson =  new GsonBuilder().setPrettyPrinting();				
		
		
		Gson gson = creadorGson.create();
				
		
						
		Reader reader = new FileReader (new File ("ejer1.json"));
						
		WrapperPersona personas = gson.fromJson(reader, WrapperPersona.class);
						
		reader.close();
		
		
		System.out.println(personas);
		
		System.out.println(gson.toJson(personas));
		

	}

}
