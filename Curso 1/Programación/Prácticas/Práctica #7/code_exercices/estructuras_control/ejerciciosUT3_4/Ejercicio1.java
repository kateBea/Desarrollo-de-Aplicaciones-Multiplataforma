package estructuras_control.ejerciciosUT3_4;

import java.util.Scanner;

/**
 * Este programa  muestra el factorial de un número
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long num = leerEntero("Entra número: ");
        System.out.printf("Factorial de %d es %d\n", num, factorial(num));

        sc.close();
    }

    /*
     * Retorna el factorial de "num"
     */
    public static long factorial(long num) {
        return num <= 0 ? 1 : num * factorial(num - 1);
    }

    /*
     * Lee un entero de la entrada estándar mostrando primero
     * el mensaje que se pasa como parámetro
     */
    public static long leerEntero(String promt) {
        long result;
        System.out.print(promt);
        result = Long.parseLong(sc.nextLine());
        return result;
    }
}