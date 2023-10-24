package ejemplos_de_uso.streams_09_29;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<Grupo> grupos = cargarDatos();
    	Stream<Alumno> stream;
    	List<String> nombres;
    	List<Float> notas;
    	long cuantos;
    	float media;
//    	
    	/*
    	stream = alumnos.stream();
    	
    	nombres = stream.filter(a -> a.getNota()>=5).
    			map (a -> a.getNombre()).
    			distinct().
    			toList();
    	
    	stream = alumnos.stream();
    	
    	cuantos = stream.filter(a -> a.getNota()>=5).count(); // reducción
    			
    	stream = alumnos.stream();
    	
    	notas = stream.map(a -> a.getNota()).toList();
    	*/
    	
    	/*
    	media = (float) alumnos.stream(). //creación
    			filter(a -> a.getNota()>=5). //transformación
    			//peek(a -> System.out.println(a)).
    			mapToDouble(a -> a.getNota()). //transformación
    			//peek(n -> System.out.println(n)).
    			average(). //consumir
    			orElse(0f);
    	
    	System.out.println(media);
    	
    	*/
    	// Mostrar el nombre del alumno de la nota más alta
    	/*
    	alumnos.stream().
    		sorted((a1,a2) -> Float.compare(a1.getNota(), a2.getNota())).
    		findFirst().
    		map(a -> a.getNombre()).
    		ifPresentOrElse(n -> System.out.println(n), 
    				() -> System.out.println("no hay alumnos"));
    	*/
    	/*
    	alumnos.stream().
			sorted((a1,a2) -> Float.compare(a1.getNota(), a2.getNota())).
			limit(1).
			map(a -> a.getNombre()).
			forEach(n -> System.out.println(n));
    	*/
    	/*
    	alumnos.stream().
    		filter((a -> a.getNota() >9)).
    		filter(a -> a.getFecha().isBefore(LocalDate.now().minusYears(22))).
    		//sorted ((a1,a2) -> a1.getNombre().compareTo(a2.getNombre())).
    		sorted (Comparator.comparing(Alumno::getNombre)).
    		map (Alumno::getNia).
    		forEach(System.out::println);
    	*/
    	
    	//grupos.stream().forEach(System.out::println);
    	
    	grupos.stream().
    			map(Grupo::getAlumnos).
    			forEach(System.out::println);
    	
    	grupos.stream().
    			flatMap (g -> g.getAlumnos().stream()).
    			distinct().
    			map (Alumno::getNombre).
    			reduce ((n1,n2) -> n1+", "+ n2).
    			ifPresent(System.out::println);
    }
    
    public static List<Grupo> cargarDatos ()
    {
    	List<Grupo> grupos = new ArrayList<>();
    	Alumno a,a1,a2;
    	
    	a = Alumno.builder().
        		nia("002").
        		nombre("miguel").
        		nota(0).
        		fecha(LocalDate.now()).
        		build();
        
        a1 = Alumno.builder().
        		nia("003").
        		nombre("tres").
        		nota(10).
        		fecha(LocalDate.now().minusYears(30)).
        		build();
        
        a2 = Alumno.builder().
        		nia("004").
        		nombre("cuatro").
        		nota(10).
        		fecha(LocalDate.now().minusYears(33)).
        		build();
        
        Grupo g  = Grupo.builder().
        				nombre("DAM2").
        				tutor("Mario").
        				alumno(a).
        				alumno(a1).
        				build();
        grupos.add(g);
        
        Grupo g1  = Grupo.builder().
				nombre("DAM1").
				tutor("Isma").
				alumno(a2).
				alumno(a).
				build();
        grupos.add(g1);
        return grupos;
    	
    }
}
