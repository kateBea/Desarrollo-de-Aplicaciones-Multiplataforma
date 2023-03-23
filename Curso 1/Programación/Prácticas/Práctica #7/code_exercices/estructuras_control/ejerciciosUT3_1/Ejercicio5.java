package estructuras_control.ejerciciosUT3_1;

import java.util.Scanner;

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

    }
}