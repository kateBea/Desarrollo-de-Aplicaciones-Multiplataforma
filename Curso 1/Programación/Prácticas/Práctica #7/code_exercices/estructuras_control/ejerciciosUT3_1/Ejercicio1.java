package estructuras_control.ejerciciosUT3_1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        int a;
        int b;

        System.out.print("Enter a: ");
        a = sc.nextInt();
        System.out.print("Enter b: ");
        b = sc.nextInt();

        System.out.println("Result: " + (a > b ? (a - b) : (b - a)));

        sc.close();
    }   
}