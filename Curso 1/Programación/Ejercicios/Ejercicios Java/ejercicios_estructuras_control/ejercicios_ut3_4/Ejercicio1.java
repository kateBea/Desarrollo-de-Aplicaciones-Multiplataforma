package ejercicios_estructuras_control.ejercicios_ut3_4;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entra número: ");
        long num = sc.nextInt();
        System.out.println("Factorial de " + num + " es " + factorial(num));

        sc.close();
    }

    public static long factorial(long num) {
        return num <= 0 ? 1 : num * factorial(num - 1);
    }
}