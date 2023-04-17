package ejerciciosUT3_5;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entra número: ");
        int a = sc.nextInt();
        System.out.println("Número de cifras de " + a + " es: " + numeroCifras(a));

        sc.close();
        
    }

    public static int numeroCifras(int num) {
        if (num % 10 == num)
            return 1;

        return 1 + numeroCifras(num / 10);
    }
}