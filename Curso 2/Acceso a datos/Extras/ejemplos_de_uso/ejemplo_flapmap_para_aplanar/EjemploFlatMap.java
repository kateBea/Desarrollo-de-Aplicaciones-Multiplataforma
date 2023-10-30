package ejemplos_de_uso.ejemplo_flapmap_para_aplanar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploFlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List <Grupo> instituto = new ArrayList<Grupo>();
		
		Grupo dam1 = new Grupo ("DAM1");
		dam1.addAlumno(new AlumnoFP ("Miguel", 20, 8.0f));
		dam1.addAlumno(new AlumnoFP ("Juan", 23, 5.0f));
		Grupo dam2 = new Grupo ("DAM2");
		dam2.addAlumno(new AlumnoFP ("Luis", 30, 4.0f));
		dam2.addAlumno(new AlumnoFP ("Antonio", 43, 5.0f));
		Grupo asir1 = new Grupo ("ASIR1");
		asir1.addAlumno(new AlumnoFP ("Felipe", 22, 5.0f));
		asir1.addAlumno(new AlumnoFP ("Pedro", 23, 6.0f));
		Grupo asir2 = new Grupo ("ASIR2");
		asir2.addAlumno(new AlumnoFP ("Angel", 25, 9.0f));
		asir2.addAlumno(new AlumnoFP ("Abel", 26, 6.0f));
		
		instituto.add(dam1);
		instituto.add(dam2);
		instituto.add(asir1);
		instituto.add(asir2);
		
		instituto.forEach(System.out::println);
		
		// Mostrar todos los alumnos del centro
		Stream <Grupo> centro = instituto.stream();	
		Stream <AlumnoFP>  alumnos = centro.flatMap(g -> g.getAlumnos().stream());
		alumnos.forEach(System.out::println);
		
		
		// Mostrar todos los nombres alumnos del centro ordenados por nombre
		instituto.stream().flatMap(g -> g.getAlumnos().stream()).map(AlumnoFP::getNombre).sorted().forEach(System.out::println);
		
		

	}

}
