package entrada_salida;

import java.util.Scanner;

/**
 * Este ejemplo muestra un uso básico de la clase Scanner
 * de la interfaz Set
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class LecturaDatosScanner {
    // Creamos el objeto Scanner y le pasamos como parámetro un InputStream
    // en este caso el que está asociado al teclado y se encuentra en la clase System
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        long numero;
        System.out.print("Introduce un número por favor: ");
        numero = lector.nextInt();
        System.out.println("El factorial de " + numero + " es: " + factorial(numero));

        // cerramos el flujo de datos
        lector.close();
    }

    public static long factorial(long numero) {
        return numero <= 0 ? 1 : (numero * factorial(numero - 1));
    }
}
