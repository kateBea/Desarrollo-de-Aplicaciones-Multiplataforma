package estructuras_control.ejerciciosUT3_4;

import java.util.Scanner;

/**
 * Este programa  muestra el factorial de un número
 * entre el 0 y el 20, ambos inclusos. El número a evaluar
 * se pide al usuario
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio2 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long num;
        
        do num = leerEntero("Entra número en el rango [0, 20]: ");
        while(num < 0 || num > 20);
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