package estructuras_control.ejerciciosUT3_3;

import java.util.Random;
import java.util.Scanner;

/**
 * Este programa muestra los divisores de un número contenido
 * en una variable y cuántos son en total. El número a ser evaluado
 * es aleatorio en el rango comprendido entre el 20 y 150, ambos inclusos
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio6 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Random rd = new Random();

        // Obtenemos un núumero aleatorio en el rango [20, 150]
        int numero = rd.nextInt(20, 151);
        int totalDivisores = 0;

        // no se incluye el número en la lista intencionadamente
        for (int valor = numero / 2; valor > 0; --valor) {
            if (esDivisible(numero, valor)) {
                System.out.printf("[ %d ] es divisor de [ %d ]\n", valor, numero);
                ++totalDivisores;
            }
        }

        System.out.printf("%d tiene un total de %d divisores, excluyéndose a sí mismo\n", numero, totalDivisores);
        
    }

    /*
     * Lee un entero de la entrada estándar mostrando primero
     * el mensaje que se pasa como parámetro
     */
    public static int leerEntero(String promt) {
        int result;
        System.out.print(promt);
        result = Integer.parseInt(sc.nextLine());
        return result;
    }

    /*
     * Retorna cierto si a es divisible por b (b es divisor de a entonces)
     */
    public static boolean esDivisible(int a, int b) {
        return a % b == 0;
    }
}