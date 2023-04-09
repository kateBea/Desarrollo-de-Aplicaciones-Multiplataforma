package estructuras_control.ejerciciosUT3_5;

/**
 * Este programa muestra de manera ascendente los números enteros del
 * 1 al 20. Para ello emplea tres bucles simples
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        int indice;

        indice = 0;
        System.out.println("**** Bucle while ****");
        while (indice < 20)
            System.out.print((indice++ + 1) + " ");

        indice = 0;
        System.out.println("\n\n**** Bucle do-while ****");
        do System.out.print((indice++ + 1) + " ");
        while (indice < 20);

        indice = 0;
        System.out.println("\n\n**** Bucle for ****");
        for (; indice < 20; ++indice)
            System.out.print((indice + 1) + " ");
    }
}