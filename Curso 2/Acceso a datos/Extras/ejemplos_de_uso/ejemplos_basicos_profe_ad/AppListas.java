package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;

public class AppListas {

	
	
	public static void main(String[] args) {
		Alumno alumno;
		List<Alumno> alumnos = new ArrayList<>();
		String respuesta;
		
		do
		{
			alumno = new Alumno();
			alumno.leerClave();
			if (!alumnos.contains(alumno))
			{
				alumno.leerOtrosDatos();
				alumnos.add(alumno);
			}
			else
				System.out.println("alumno repetido");
			
			respuesta = Teclado.leerString("continuar(s/n");
		}while (respuesta.equalsIgnoreCase("s"));
		
		for (int i = alumnos.size()-1; i >=0; i--)
			System.out.println(alumnos.get(i));
		
	}

}
