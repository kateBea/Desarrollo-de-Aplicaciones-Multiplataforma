package dam2.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClienteRest {
	public static final InputStreamReader input = new InputStreamReader(System.in);
	public static final BufferedReader reader = new BufferedReader(input);
	
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
			
		}
		case 2 -> {
			
		}
		case 3 -> {
			
		}
		case 4 -> {
			
		}
		default -> System.err.println("Error opción");
		}
	}

	private static void mostrarMenu() {
		System.out.println("1. Hacer préstamo");
		System.out.println("2. Hacer devolución");
		System.out.println("3. Mostrar sanción");
		System.out.println("4. Consultar ejemplares");
	}

	public static int leerOpcion() {
		int result = 0;
		try {
			result = Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return result;
	}
}
