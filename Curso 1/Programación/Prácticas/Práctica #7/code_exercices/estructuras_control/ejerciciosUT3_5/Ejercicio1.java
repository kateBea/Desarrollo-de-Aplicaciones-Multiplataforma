package estructuras_control.ejerciciosUT3_5;

import java.util.Scanner;

/**
 * Este programa  muestra la cantidad de cifras de un número
 * que se lee por la entrada de datos
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long a = leerEntero("Entra un número entero: ");
        System.out.println("Número de cifras de " + a + " es: " + numeroCifras(a));

        sc.close();
        
    }

    /*
     * Retorna la cantidad de cifras de "num"
     */
    public static long numeroCifras(long num) {
        if (num % 10 == num)
            return 1;

        return 1 + numeroCifras(num / 10);
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