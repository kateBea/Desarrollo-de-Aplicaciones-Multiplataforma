package estructuras_control.ejerciciosUT3_3;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double base;
        double altura;

        System.out.print("Base:   ");
        base = sc.nextDouble();
        System.out.print("Altura: ");
        altura = sc.nextDouble();

        System.out.println("Área rectángulo: " + ((base * altura) / 2));

        sc.close();
    }
}