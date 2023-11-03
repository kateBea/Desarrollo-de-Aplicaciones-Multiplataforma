package dam2.org.json;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LeerJSON {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	
		Gson gson = new Gson();
		
		Empleado e;
		
		
		// Leer de fichero de empresa
		
		Empresa empresa;
		
		Reader reader = new FileReader (new File ("empresa.json"));
		
		empresa = gson.fromJson(reader, Empresa.class);
		
		reader.close();
		
		System.out.println(empresa);
		
		
		
		// Leer fichero de empleados como lista
		List<Empleado> empleados;
		
		reader = new FileReader (new File ("empleados.json"));
		//No se puede hacer
		//empleados = gson.fromJson(reader, ArrayList.class);
		
		// Alternativa 1
		//ListaDeEmpleados listaDeEmpleados = new ListaDeEmpleados();
		
		// Alternativa 2
		TypeToken<List<Empleado>> listaDeEmpleados = new TypeToken<List<Empleado>>() {};
		
		empleados = gson.fromJson(reader, listaDeEmpleados.getType());
		
		//System.out.println(empleados);
			
		
		for (Empleado emp: empleados)
			System.out.println(emp.toString());
		
	}

}
