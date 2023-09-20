package ejemplos_basicos_profe_ad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import daw.com.Teclado;

public class AppSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno alumno;
		Set<Alumno> alumnos = new HashSet<>();
		String respuesta;
		
		do
		{
			alumno = new Alumno();
			alumno.leerClave();
			if (alumnos.add(alumno))
			{
				alumno.leerOtrosDatos();
			}
			else
				System.out.println("alumno repetido");
			
			respuesta = Teclado.leerString("continuar(s/n");
		}while (respuesta.equalsIgnoreCase("s"));
		
		
		for (Alumno a: alumnos)
			System.out.println(a);
	}

}
