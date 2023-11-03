package org.dam2.json;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EsribirJSON {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Gson gson = new Gson();
		String json;
		List<Empleado> empleados = new  ArrayList<>();
		
		
		Empleado e = new Empleado();
		e.leerEmpleado();
		
		
		
		json = gson.toJson(e);
		
		System.out.println(json);
		
		empleados.add(e);
		
		
		PrintWriter fichero = new PrintWriter (new File("empleados.json"));
		gson.toJson(empleados,fichero);
		
		fichero.close();
		
		json = gson.toJson(empleados);
		System.out.println(json);
		
		
		
		
		
		
		Empresa empresa = new Empresa ("villablanca", empleados);
		
		
		GsonBuilder creador = new GsonBuilder().setPrettyPrinting();
		
		Gson prettyGson = creador.create();
		
		String jsonCadena = prettyGson.toJson(empresa);
		System.out.println(jsonCadena);
		
		PrintWriter ficheroEmpresa = new PrintWriter (new File("empresa.json"));
		prettyGson.toJson(empresa,ficheroEmpresa);
		ficheroEmpresa.close();
		
	}

}
