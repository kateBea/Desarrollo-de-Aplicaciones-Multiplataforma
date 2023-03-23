package estructuras_control.ejerciciosUT3_3;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int base;
        int altura;

        System.out.print("Base:   ");
        base = sc.nextInt();
        System.out.print("Altura: ");
        altura = sc.nextInt();

        if (esMultiple(base, altura) && base > altura)
            System.out.println("Área rectángulo: " + ((base * altura) / 2));
        else 
            System.out.println("Base menor o igual que altura o base no múltiple de altura.");

        sc.close();
    }

    public static boolean esMultiple(int num1, int num2) {
        // existe entero que multiplicado por num2
        // nos da num1
        return num1 % num2 == 0;
    }
}