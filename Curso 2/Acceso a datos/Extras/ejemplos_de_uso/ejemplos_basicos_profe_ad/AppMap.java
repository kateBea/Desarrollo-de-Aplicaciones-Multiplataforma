package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import daw.com.Teclado;

public class AppMap {

	public static void main(String[] args) {
		Alumno alumno;
		Map<String,Alumno> alumnos = new TreeMap<>();
		String respuesta,nia;
		
		do
		{
			nia = Teclado.leerString("nia");
			if (!alumnos.containsKey(nia))
			{
				alumno = new Alumno (nia);
				alumno.leerOtrosDatos();
				alumnos.put(nia, alumno);
			}
			else
				System.out.println("alumno repetido");
			
			respuesta = Teclado.leerString("continuar(s/n)");
		}while (respuesta.equalsIgnoreCase("s"));
		
		for (Alumno a: alumnos.values())
			System.out.println(a);
		
		for (String n: alumnos.keySet())
			System.out.println(n);
		
		for (Entry e: alumnos.entrySet())
			System.out.println(e.getKey() + "->"+ e.getValue());

	}

}
