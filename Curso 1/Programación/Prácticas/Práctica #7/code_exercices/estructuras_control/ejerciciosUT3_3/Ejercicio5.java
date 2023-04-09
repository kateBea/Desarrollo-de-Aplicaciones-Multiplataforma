package estructuras_control.ejerciciosUT3_3;

import java.util.Scanner;

/**
 * Este programa muestra el área de un rectángulo, en el caso
 * que la base sea mayor que la altura no se realiza ningún cálculo
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio5 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // ambos declarados como enteros porque la propiedad de
        // multiplicidad solo tiene sentido para enteros
        int base = leerEntero("Base:   ");
        int altura = leerEntero("Altura: ");;

        if (base > altura && esDivisible(base, altura))
            System.out.println("Área rectángulo: " + ((base * altura) / 2));
        else 
            System.out.println("Base menor o igual que altura o base no múltiple de altura.");

        sc.close();
    }

    /*
     * Retorna cierto si a es divisible por b (b es divisor de a entonces)
     */
    public static boolean esDivisible(int a, int b) {
        return a % b == 0;
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
}