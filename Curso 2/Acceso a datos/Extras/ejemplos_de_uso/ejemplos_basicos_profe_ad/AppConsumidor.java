package ejemplos_de_uso.ejemplos_basicos_profe_ad;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import daw.com.Teclado;

public class AppConsumidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno alumno;
		List<Alumno> alumnos = new ArrayList<>();
		String respuesta;
		Consumer<Alumno> consumidor, subirNota;
		
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
		
		// clase anónima
		subirNota = new Consumer<Alumno>()
				{
			@Override
			public void accept(Alumno a) {
				// TODO Auto-generated method stub
				a.setNota(a.getNota()+1);
				
				}
			};
			
			
		alumnos.forEach(subirNota);
		alumnos.forEach(consumidor);
		
		

	}

}
