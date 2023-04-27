package ejercicios_estructuras_control.ejercicios_ut3_2;

import java.util.Scanner;

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