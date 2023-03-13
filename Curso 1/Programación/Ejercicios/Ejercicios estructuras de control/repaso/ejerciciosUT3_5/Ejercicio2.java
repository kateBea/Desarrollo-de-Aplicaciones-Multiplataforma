package ejerciciosUT3_5;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Rango infeior:  ");
        int ri = sc.nextInt();

        System.out.print("Rango superior: ");
        int rs = sc.nextInt();

        System.out.print("Lista: ");
        rango(ri, rs);

        sc.close();
    }

    public static void rango(int ri, int rs) {
        if (ri < rs) {
            rango(ri + 1, rs);
        }
       
        System.out.print(ri + " ");
    }
}