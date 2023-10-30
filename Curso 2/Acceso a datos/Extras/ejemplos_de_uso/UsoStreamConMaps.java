package ejemplos_de_uso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class UsoStreamConMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Alumno> alumnos;
		alumnos = EjercicioLambdas.cargarAlumnos();

		// Crear un Map de alumnos
		HashMap <String,Alumno> alumnosMap = new HashMap <>();
		alumnos.stream().forEach(a -> alumnosMap.put(a.getNia(), a));
		
		// Mostrar Map
		System.out.println(alumnosMap);
		
		
		
		// Convertir Map a stream
		Stream <Map.Entry<String,Alumno>> mapToStream;
		mapToStream = alumnosMap.entrySet().stream();
		
		// consumir un stream de map
		System.out.println("Mostrar map separado");
		mapToStream.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue() ));
		
		// filtrar un stream de map
		System.out.println("Mostrar map filtrado");
		alumnosMap.entrySet().stream().filter(entry -> entry.getValue().getNota() >= 5).forEach(System.out::println);
		
		// ordenar un stream de map
		System.out.println("Mostrar map ordenado");
		alumnosMap.entrySet().stream().
				sorted((e1,e2) -> e1.getValue().getNombre().compareTo(e2.getValue().getNombre())).
				forEach (System.out::println);
		
	}

}
