package estructuras_control.ejerciciosUT3_2;

import java.util.Scanner;

/**
 * Este programa pide al usuario un entero y muestra
 * por pantalla la letra 'A' tantas veces como este indique
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entra número: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; ++i)
            System.out.println('A');

        sc.close();
    }
}