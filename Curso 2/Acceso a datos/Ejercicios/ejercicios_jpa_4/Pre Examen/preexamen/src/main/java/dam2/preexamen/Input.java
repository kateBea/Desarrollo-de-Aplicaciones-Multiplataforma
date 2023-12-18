package dam2.preexamen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
	private static InputStreamReader input;
	private static BufferedReader lector;
	
	public static void init() {
		input = new InputStreamReader(System.in);
		lector = new BufferedReader(input);
	}
	
	public static String leerCadena(String prompt) {
		String resultado = null;
		
		try {
			if (prompt != null) { System.out.print(prompt); }
			
			resultado = lector.readLine();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
			
		return resultado;
	}
	
	public static String leerCadena() {
		return leerCadena(null);
	}
	
	public static Integer leerEntero(String prompt) {
		String input = leerCadena(prompt);
		
		if (input == null) {
			return null;
		}
		
		return Integer.parseInt(input);
	}
	
	public static Double leerReal(String prompt) {
		String input = leerCadena(prompt);
		
		if (input == null) {
			return null;
		}
		
		return Double.parseDouble(input);
	}
}
