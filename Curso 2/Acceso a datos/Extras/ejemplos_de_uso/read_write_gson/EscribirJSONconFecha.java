package org.dam2.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscribirJSONconFecha {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		

		EmpresaConFecha empresa = new EmpresaConFecha ();
		
		empresa.setNombre("villablanca");
		empresa.setFecha(LocalDate.now().minusDays(30)); // un mes antes de hoy
		
		Empleado e = new Empleado ("001","miguel", "infor", 999);
		empresa.getEmpleados().add(e);
		
		// poner bonito el json
		GsonBuilder creadorGson = new GsonBuilder().setPrettyPrinting();
		
		// poner adaptador de fechas
		creadorGson.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
		
		Gson gson = creadorGson.create();
		
		
		String json = gson.toJson(empresa);
		System.out.println(json);
		
		PrintWriter ficheroEmpresa = new PrintWriter (new File("empresaConFecha.json"));
		gson.toJson(empresa,ficheroEmpresa);
		ficheroEmpresa.close();

	}

}
