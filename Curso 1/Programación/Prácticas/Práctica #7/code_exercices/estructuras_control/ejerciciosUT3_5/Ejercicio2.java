package estructuras_control.ejerciciosUT3_5;

import java.util.Scanner;

/**
 * Este programa muestra de manera descendente los número comprendidos en un
 * rango. El rango se pide al usuario y está compuesto por enteros únicamente
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio2 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        long ri = leerEntero("Rango infeior:  ");
        long rs = leerEntero("Rango superior: ");

        if (ri > rs) {
            System.out.println("Error: rango inválido");
        }
        else {
            System.out.print("Lista: ");
            rango(ri, rs);
        }

        System.out.println();

        sc.close();
    }

    /*
     * Muestra descendentemente los enteros en un rango
     */
    public static void rango(long ri, long rs) {
        if (ri < rs) {
            rango(ri + 1, rs);
        }
       
        System.out.print(ri + " ");
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