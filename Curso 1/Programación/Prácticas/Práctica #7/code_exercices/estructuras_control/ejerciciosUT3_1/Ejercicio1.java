package estructuras_control.ejerciciosUT3_1;

import java.util.Scanner;

/**
 * Este programa lee dos número enteros diferentes de la entrada 
 * de datos y muestra por pantalla la suma de sus valores absolutos
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = leerEntero("Enter a: ");
        int b = leerEntero("Enter b: ");

        System.out.println("Result: " + (a > b ? (a - b) : (b - a)));
        sc.close();
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