package estructuras_control.ejerciciosUT3_4;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num;
        
        do {
            System.out.print("Entra número en el rango [0, 20]: ");
            num = sc.nextInt();
        }
        while(num < 0 || num > 20);

        System.out.println("Factorial de " + num + " es " + factorial(num));
    }

    public static long factorial(long num) {
        return num <= 0 ? 1 : num * factorial(num - 1);
    }
}