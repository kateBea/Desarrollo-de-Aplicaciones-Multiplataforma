package entrada_salida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Este ejemplo muestra un uso básico de la clase BufferedReader
 * de la interfaz Set
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class LecturaDatosBufferedReader {
    // Creamos el objeto InputStreamReader y pasamos un InputStream
    // en este caso el que está asociado al teclado y se encuentra en la clase System
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        long numero;
        System.out.print("Introduce un número por favor: ");
        numero = Long.parseLong(lector.readLine());
        System.out.println("El factorial de " + numero + " es: " + factorial(numero));
    }

    public static long factorial(long numero) {
        return numero <= 0 ? 1 : (numero * factorial(numero - 1));
    }
}
