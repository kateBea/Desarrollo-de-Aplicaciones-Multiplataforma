package examen.respuestas;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Examen simulacro
 *
 */
public class App 
{
	// Listado de institutos
	private static List<Instituto> institutos;
	
	// Predicados
	static final Predicate<Persona> MAYOR_EDAD = 
			persona -> Period.between(persona.getFechaNacimiento(), LocalDate.now().plusYears(1)).getYears() >= 18;
	
	public static class Cuestion1 implements Runnable {
		@Override
		public void run() {
			System.out.println("Ejercicio 1:");
			
			// Listado del nombre y el número de teléfono, ordenado por nombre, de 
			// todos los institutos cuyo código de centro comience por “28”
			institutos.stream().
				filter(instituto -> instituto.getCodigo().startsWith("28")).
				forEach(i -> System.out.println("Nombre: " + i.getNombre() + " Telf: " + i.getTelefono()));
		}
	}
	
	public static class Cuestion2 implements Runnable {
		@Override
		public void run() {
			System.out.println("Ejercicio 2:");
			
			// Listado del nombre de todas las personas de todos los institutos 
			// que tengan un vehículo de color “verde”.
			institutos.stream().map(insti -> insti.getPersonas()).
				flatMap(listaPers -> listaPers.stream()).
				filter(persona -> persona.getVehiculo().map(vehiculo -> vehiculo.getColor().equalsIgnoreCase("Verde")).orElse(false)).
				forEach(System.out::println);
		}
	}
	
	public static class Cuestion3 implements Runnable {
		@Override
		public void run() {
			System.out.println("Ejercicio 3:");
			
			// Listado de todas las compañías de telecomunicaciones de todas las 
			// personas mayores de edad de todos los institutos.
			institutos.stream().
				flatMap(insti -> insti.getPersonas().stream()).
				filter(MAYOR_EDAD).
				map(Persona::getContacto).
				map(Contacto::getEmpresa).
				distinct().
				forEach(System.out::println);
		}
	}
	
	public static class Cuestion4 implements Runnable {
		@Override
		public void run() {
			System.out.println("Ejercicio 4:");
			
			// Total del presupuesto de todos los institutos que tengan más de una persona.
			
			final Predicate<Instituto> INSTITUTO_MAS_DE_UNA_PERSONA = 
					instituto -> instituto.getPersonas().size() > 1;
					
			System.out.println("Total de presupuesto: " +  
					institutos.stream().
					filter(INSTITUTO_MAS_DE_UNA_PERSONA).
					mapToDouble(instituto -> instituto.getPresupuesto()).sum());
		}
	}
	
	public static class Cuestion5 implements Runnable {
		@Override
		public void run() {
			System.out.println("Ejercicio 5:");
			
			// Listado de los centros de adultos, es decir los institutos que 
			// no tengan alumnos menores de edad.
			final Predicate<Instituto> INSTITUTO_ADULTOS =
					instituto -> instituto.getPersonas().stream().allMatch(MAYOR_EDAD);
					
			institutos.stream().
			filter(INSTITUTO_ADULTOS).
			forEach(insti -> System.out.println("Nombre: '" + insti.getNombre() + "' Código: " + "'" + insti.getCodigo() + "'"));
		}
	}
	
	public static class Cuestion6 implements Runnable {
		@Override
		public void run() {
			System.out.println("Ejercicio 6:");
			
			// Listado del nombre y todos los datos de todos los teléfonos de 
			// contactos de todas las personas menores de edad por nombre de instituto.
			final Function<Persona, String> NOMBRE_CONTACTOS =
				persona -> persona.getNombre() + " Contactos: " +
				"numero(" + persona.getContacto().getNumero() + ") " +
				"os(" + persona.getContacto().getNumero() + ") ";
				
			final Function<Instituto, Stream<String>> NOMBRE_CONTACTOS_PERSONAS_MENORES =
				insti -> insti.getPersonas().stream().filter(MAYOR_EDAD.negate()).map(NOMBRE_CONTACTOS);
				
			institutos.stream().sorted(Comparator.comparing(Instituto::getNombre)).map(NOMBRE_CONTACTOS_PERSONAS_MENORES).
				forEach(System.out::println);
			
		}
	}
	
    public static void main( String[] args )
    {
    	inicializarDatos();
    	
    	List<Runnable> respuestas = new LinkedList<>();
    	
    	respuestas.add(new Cuestion1());
    	respuestas.add(new Cuestion2());
    	respuestas.add(new Cuestion3());
    	respuestas.add(new Cuestion4());
    	respuestas.add(new Cuestion5());
    	respuestas.add(new Cuestion6());
    	
    	for (Runnable task : respuestas) {
    		task.run();
    		
    		System.out.println('\n');
    	}
    }
    
    public static void inicializarDatos() {
    	institutos = new ArrayList<>();
    	
    	Persona rosalia = Persona.builder().nombre("Rosalía").nif("0044F").
    			fechaNacimiento(LocalDate.of(1984, 7, 12)).
    			contacto(Contacto.builder().empresa("Movistar").numero("722 33 53 11").os("642 11 33 22").build()).
    			vehiculo(Optional.of(Vehiculo.builder().modelo("Ryzen").color("Naranja").matricula("5542 RTS").build())).build();
    	
    	Persona pedro = Persona.builder().nombre("Pedro").nif("8563R").
    			fechaNacimiento(LocalDate.of(1982, 1, 12)).
    			contacto(Contacto.builder().empresa("EpicGames").numero("744 22 33 11").os("722 33 22 11").build()).
    			vehiculo(Optional.of(Vehiculo.builder().modelo("Renault").color("Violeta").matricula("7542 YTR").build())).build();
    	
    	Persona miguel = Persona.builder().nombre("Miguel").nif("0231J").
    			fechaNacimiento(LocalDate.of(1988, 5, 11)).
    			contacto(Contacto.builder().empresa("EpicGames").numero("634 83 57 11").os("663 12 44 11").build()).
    			vehiculo(Optional.ofNullable(null)).build();
    	
    	Persona laya = Persona.builder().nombre("Laya").nif("7453I").
    			fechaNacimiento(LocalDate.of(1991, 2, 22)).
    			contacto(Contacto.builder().empresa("EA Sports").numero("632 11 22 33").os("722 44 22 11").build()).
    			vehiculo(Optional.of(Vehiculo.builder().modelo("CRY").color("Verde").matricula("8947 UTE").build())).build();
    	
    	Instituto insti1 = Instituto.builder().
    			nombre("IES Villaverde").
    			codigo("29537YT").
    			telefono("91 663 11 33").
    			presupuesto(25361.82).
    			personas(Arrays.asList(rosalia, miguel)).build();
    	
    	Instituto insti2 = Instituto.builder().
    			nombre("IES Don Quijote").
    			codigo("28528KG").
    			telefono("91 273 22 73").
    			presupuesto(12547.122).
    			personas(Arrays.asList(pedro, laya)).build();
    	
    	institutos.add(insti1);
    	institutos.add(insti2);
    }
}
