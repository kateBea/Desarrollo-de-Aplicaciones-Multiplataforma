package org.dam2.ejer3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.dam2.json.EmpresaConFecha;
import org.dam2.json.LocalDateAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import daw.com.Teclado;

public class AppEjer3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		GsonBuilder creadorGson = new GsonBuilder();				
		// poner adaptador de localidades o localidad
		creadorGson.registerTypeAdapter(Localidades.class, new LocalidadesAdapter());
		
		Gson gson = creadorGson.create();
				
		
						
		Reader reader = new FileReader (new File ("ej3.json"));
						
		Ejer3 ejer3 = gson.fromJson(reader, Ejer3.class);
						
		reader.close();
		
		/*
		System.out.println("Listado de Provincias");
		ejer3.getLista().getProvincia().stream().
					map(Provincia::getNombre).forEach(System.out::println);
					
		*/

		/*
		System.out.println("Listado de Localidades");
		ejer3.getLista().getProvincia().stream().map(Provincia::getLocalidades).
						flatMap (l -> l.getLocalidad().stream())
						.distinct().
						forEach(System.out::println);
		*/
		
		/*
		System.out.println("Lista de provincias y el total de municipios que tiene cada una");
		ejer3.getLista().getProvincia().
					stream().
					collect(Collectors.toMap(Provincia::getNombre, p -> p.getLocalidades().getLocalidad().stream().count())).
					forEach((nombre, cuantos)-> System.out.println(nombre.getData() + " ->" + cuantos));
		*/
		
		/*
		System.out.println("Leer por teclado el nombre de una provincia y mostrar sus municipios");
		String provincia = Teclado.leerString("nombre provincia");
		ejer3.getLista().getProvincia().
							stream().
							filter(p -> p.getNombre().getData().equals(provincia)).
							flatMap(p->p.getLocalidades().getLocalidad().stream()).
							map(Localidad::getData).
							forEachOrdered(System.out::println);
		*/
		
		/*
		System.out.println("Leer por teclado el nombre de un municipio y mostrar la provincia donde se encuentra.");
		String localidad = Teclado.leerString("Localidad");
		String prov =ejer3.getLista().getProvincia().
							stream().
							filter (p -> p.getLocalidades().getLocalidad().stream().anyMatch(l -> l.getData().equals(localidad))).
							map(p -> p.getNombre().getData()).
							collect(Collectors.joining(",", "Listado de Provincias: ", ""));
							
		System.out.println(prov);
		*/
		
		/*
		 * En una lista tenemos distintos identificadores de provincias, 
		 * mostrar el nombre de las provincias y todos los municipios 
		 * correspondientes a los identificadores que se encuentran en la lista.
		 */
		
		/*	
		System.out.println("Listado de provincias y localidades en lista de códigos");
		Function <Provincia, String> listaDeLocalidades;
		listaDeLocalidades = p -> p.getLocalidades().getLocalidad().stream().map(Localidad::getData).collect(Collectors.joining(","));
		
		List<String> codigos = Arrays.asList("02", "50", "28");
		ejer3.getLista().getProvincia().
				stream().
				filter(p -> codigos.contains(p.getId())).		
				collect(Collectors.toMap(Provincia::getNombre, listaDeLocalidades)).
				forEach((nombre, lista) -> System.out.println(nombre.getData() + "->" + lista));
		*/
		
		mostrarProvinciajson (ejer3);
				

	}
	
	public static void mostrarProvinciajson (Ejer3 ejer3)
	{
		GsonBuilder creador = new GsonBuilder().setPrettyPrinting();
		creador.registerTypeAdapter(Localidades.class, new LocalidadesAdapter());
		Gson prettyGson = creador.create();
		
		ejer3.getLista().getProvincia().removeIf(p -> !p.getNombre().getData().equals("Alava"));
		
		String jsonCadena = prettyGson.toJson(ejer3);
		System.out.println(jsonCadena);
		
		
	}

}
