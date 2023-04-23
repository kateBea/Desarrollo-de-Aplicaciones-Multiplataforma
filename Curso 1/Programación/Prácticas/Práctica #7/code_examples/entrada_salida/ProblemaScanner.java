package entrada_salida;

import java.util.Scanner;

/**
 * Este ejemplo muestra una posible solución
 * a cierto problema al utilizar un objeto Scanner
 * para la lectura de datos de la entrada estándar
 * de la interfaz Set
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class ProblemaScanner {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String... args) {
        System.out.print("¿Cómo te llamas? ");
        String nombre = scanner.nextLine();

        System.out.print("¿Y cual es tu edad? ");
        int edad = scanner.nextInt();

        // consumir salto de línea extra
        scanner.nextLine();

        System.out.printf("Hola %s. Tienes %d años\n", nombre, edad);
        scanner.close();
    }
}