package estructuras_control.ejerciciosUT3_5;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Primer número:  ");
        int a = sc.nextInt();
        System.out.print("Segundo número: ");
        int b = sc.nextInt();
        System.out.print("Tercer número:  ");
        int c = sc.nextInt();

        if (a != b && b != c)
            System.out.println("Son diferentes entre sí");

        if (a < b) {
            if (a < c) {
                System.out.print(a + " ");
                System.out.print(Math.min(b, c) + " ");
            }
            else {
                System.out.print(c + " ");
                System.out.print(a + " ");
            }
            
            System.out.print(Math.max(b, c) + "\n");
        }   
        else {
            if (b < c) {
                System.out.print(b + " ");
                System.out.print(Math.min(a, c) + " ");
            }
            else {
                System.out.print(c + " ");
                System.out.print(b + " ");
            }

            System.out.print(Math.max(a, c) + "\n");
        }

        // enunciado ambigua, no se explicita qué "es número central"
        // se asume el segundo
        if (b >= a && b <= c) {
            // intervalo [a....b....c]
            if (c - b > b - a) 
                System.out.println("Más próximo a extremo izquierdo.");
            else if (c - b == b - a)
            System.out.println("Valor intermedio");
            else 
                System.out.println("Más próximo a extremo derecho.");
        }
        else 
            System.out.println("El central no está entre los límites.");

        sc.close();
    }
}