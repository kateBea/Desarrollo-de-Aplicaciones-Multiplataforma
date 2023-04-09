package estructuras_control.ejerciciosUT3_3;

import java.util.Scanner;

/**
 * Este programa muestra el área de un triángulo
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio4 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double base = leerReal("Base:   ");
        double altura = leerReal("Altura: ");

        System.out.println("Área rectángulo: " + ((base * altura) / 2));

        sc.close();
    }

    /*
     * Lee un entero de la entrada estándar mostrando primero
     * el mensaje que se pasa como parámetro
     */
    public static Double leerReal(String promt) {
        double result;
        System.out.print(promt);
        result = Double.parseDouble(sc.nextLine());
        return result;
    }
}