package estructuras_control.ejerciciosUT3_1;

import java.util.Scanner;

/**
 * Este programa muestra un número  entero  y pide  que  se  teclee  el  
 * mismo número mostrado por teclado, la ejecución no cesa hasta que 
 * el usuario cumple el encargo
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        int n, muestra = 1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Muestra: " + (muestra));

            System.out.print("Entra número: ");
            n = sc.nextInt();

        }
        while(n != muestra++);

        sc.close();
    }
}