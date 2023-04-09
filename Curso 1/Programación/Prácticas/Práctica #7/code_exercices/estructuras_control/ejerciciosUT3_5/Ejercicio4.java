package estructuras_control.ejerciciosUT3_5;

import java.util.Scanner;

/**
 * Este programa muestra si un número introducido por el usuario 
 * es múltiplo de 2, de 3, de 5, de varios de ellos o de ninguno de ellos
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio4 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long userInput = leerEntero("Introduce un número entero: ");
        

        if (multiploDe(userInput, 2 * 3 * 5))
            System.out.println("El número es múltiplo de 2, 3 y 5");
        else {
            if (multiploDe(userInput, 2))
                System.out.println("El número es múltiplo de 2");
            if (multiploDe(userInput, 3))
                System.out.println("El número es múltiplo de 3");
            if (multiploDe(userInput, 5))
                System.out.println("El número es múltiplo de 5");
        }
    
        sc.close();
    }

    /*
     * Retorna cierto se dividendo es múltiplo de divisor, es decir,
     * existe un entero tal que multiplicado por divisor nos da dividendo.
     * Retorna falso en caso contrario
     */
    public static boolean multiploDe(long dividendo, long divisor) {
        return dividendo % divisor == 0;
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