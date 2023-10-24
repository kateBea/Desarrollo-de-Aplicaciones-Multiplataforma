package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import daw.com.Teclado;

public class AppPredicado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno alumno;
		List<Alumno> alumnos = new ArrayList<>();
		String respuesta;
		Consumer<Alumno> consumidor;
		Predicate<Alumno> estaAprobado, mayorDeEdad;
		
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
		
		mayorDeEdad = new Predicate<Alumno>()
				{

					@Override
					public boolean test(Alumno a) {
						// TODO Auto-generated method stub
						return a.getFechaNacimiento().
								isBefore(LocalDate.now().minusYears(18));
					}
			
				};
			
		alumnos.forEach(consumidor);
		estaAprobado = new Aprobado();
		
		alumnos.removeIf(estaAprobado.and(mayorDeEdad));

		alumnos.forEach(consumidor);
	}

}
