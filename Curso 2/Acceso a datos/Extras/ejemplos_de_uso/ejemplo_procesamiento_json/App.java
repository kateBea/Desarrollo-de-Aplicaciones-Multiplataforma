package ejemplos_de_uso.ejemplo_procesamiento_json;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	Gson gson;
		String json;
		List<Empleado> empleados = new  ArrayList<>();
		
		
		Empleado e = Empleado.builder().
						id("001").
						nombre("miguel").
						dept("infor").
						sueldo(200).
						build();
		
		Empleado e1 = Empleado.builder().
				id("002").
				nombre("otro").
				dept("infor").
				sueldo(1200).
				build();
		
		GsonBuilder creador = new GsonBuilder().setPrettyPrinting();
		
		Gson prettyGson = creador.create();
		
		json = prettyGson.toJson(e);
		
		System.out.println(json);
		
		empleados.add(e);
		empleados.add(e1);
		
		PrintWriter fichero = new PrintWriter ("empleados.json");
		prettyGson.toJson(empleados,fichero);
		
		fichero.close();
		
		json = prettyGson.toJson(empleados);
		System.out.println(json);
    }
}
