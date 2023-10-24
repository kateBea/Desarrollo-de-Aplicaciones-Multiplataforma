package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import daw.com.Teclado;

public class AppComparador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno alumno;
		List<Alumno> alumnos = new ArrayList<>();
		String respuesta;
		Consumer<Alumno> consumidor;
		Comparator<Alumno> comparador,comparadorPorEdad;
		
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
		
		consumidor = new Escribidor();
		
	
		comparador = new ComparadorPorNota();
		
		
		comparadorPorEdad = new Comparator<Alumno>()
				{

					@Override
					public int compare(Alumno a1, Alumno a2) {
						// TODO Auto-generated method stub
						return a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento());
					}
			
				};
	
		alumnos.forEach(consumidor);
		alumnos.sort(comparador.thenComparing(comparadorPorEdad.reversed()));
		alumnos.forEach(consumidor);
		
		

	}

}
