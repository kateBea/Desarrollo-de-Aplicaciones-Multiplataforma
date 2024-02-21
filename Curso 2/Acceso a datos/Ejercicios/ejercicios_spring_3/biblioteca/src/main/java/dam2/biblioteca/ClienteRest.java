package dam2.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import dam2.biblioteca.modelo.Ejemplar;
import dam2.biblioteca.modelo.Prestamo;
import dam2.biblioteca.modelo.Usuario;

public class ClienteRest {
	public static final RestTemplate REST_TEMPLATE = new RestTemplate();
 	public static final InputStreamReader input = new InputStreamReader(System.in);
	public static final BufferedReader reader = new BufferedReader(input);
	
	final static String URLBASE_EJEMPLAR = "http://localhost:8080/biblioteca/ejemplares";
	final static String URLBASE_USUARIO = "http://localhost:8080/biblioteca/usuarios";
	final static String URLBASE_LIBRO = "http://localhost:8080/biblioteca/libros";
	final static String URLBASE_SANCION = "http://localhost:8080/biblioteca/sanciones";
	final static String URLBASE_PRESTAMO = "http://localhost:8080/biblioteca/prestamos";
			
	public static void main(String[] args) {
		final int SALIR = 5;
		
		int opcion;
		
		do {
			mostrarMenu();
			opcion = leerOpcion();
			
			procesarOpcion(opcion);
			
		} while (opcion != SALIR);
	}
	
	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1 -> {		
			// Consultar usuario
			Usuario usuario = recogerUsuario();
			
			// Verificar que puede hacer préstamo
			
			// Mostrar ejemplares
			Ejemplar ejemplar = null;
			
			List<Ejemplar> ejemplares = 
				List.of(REST_TEMPLATE.
						getForEntity(URLBASE_EJEMPLAR + "/consultar", Ejemplar[].class).
							getBody());
			
			int indice = 0;
			for (Ejemplar item : ejemplares) {
				System.out.println((indice++) + ".- " + item);
			}
			
			indice = Integer.parseInt(leerCadena("Introduce un índice: "));
			
			// Realizar préstamo
			Prestamo prestamo = Prestamo.builder().
					fecha(LocalDate.now()).
					devuelto(false).
					usuario(usuario).
					ejemplar(ejemplares.get(indice)).build();
			
			System.out.println(prestamo);
			
			REST_TEMPLATE.postForEntity(URLBASE_PRESTAMO + "/registrar", prestamo, Prestamo.class);
		}
		case 2 -> {
			// Consultar usuario
			Usuario usuario = recogerUsuario();
			
			// Hacer devolucion
		}
		case 3 -> {
			// Recoger usuario y contraseña
			Usuario usuario = recogerUsuario();
			
			// Mostrar sanciones si credenciales son válidos
		}
		case 4 -> {
			// Recoger usuario y contraseña
			Usuario usuario = recogerUsuario();
			
			// Recoger datos del ejemplar y consultar por disponiblidad
				
		}
		default -> System.err.println("Error opción");
		}
	}
	
	public static Usuario recogerUsuario() {
		String nombre = leerCadena("Nombre usuario: ");
		String password = leerCadena("Contraseña usuario: ");
		Usuario usuario = null;
				
		return usuario;
	}

	private static void mostrarMenu() {
		System.out.println("1. Hacer préstamo");
		System.out.println("2. Hacer devolución");
		System.out.println("3. Mostrar sanciónes de un usario");
		System.out.println("4. Consultar ejemplares");
		System.out.println("5. Salir");
	}

	public static int leerOpcion() {
		System.out.print("Entre índice válido por favor: ");
		int result = 0;
		try {
			result = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	
	public static String leerCadena(String prompt) {
		if (prompt != null) {
			System.out.print(prompt);
		}
		
		String result = "";
		
		try {
			result = reader.readLine();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return result;
	}
}
