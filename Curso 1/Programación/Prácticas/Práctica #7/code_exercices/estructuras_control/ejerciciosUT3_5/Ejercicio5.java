package estructuras_control.ejerciciosUT3_5;

import java.util.Scanner;

/**
 * Este programa toma tres números distintos por teclado, 
 * comprueba que son diferentes entre sí, y los ordena
 * de menor a mayor
 * 
 * Creado por Hugo Pelayo
 * 25 de marzo de 2023
 */
public class Ejercicio5 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        long a = leerEntero("Primer número:  ");
        long b = leerEntero("Segundo número: ");
        long c = leerEntero("Tercer número:  ");

        if (a != b && b != c)
            System.out.println("Son diferentes entre sí");
        else {

        }

        // enunciado ambiguo, no se explicita qué es 
        // "número central", se asume el segundo, tenemos
        // entonces intervalos [a....b....c]
        if (b >= a && b <= c) {
            // en caso que be sea un valor que esté en medio
            if (c - b > b - a) 
                System.out.println("Más próximo a extremo izquierdo.");
            else if (c - b == b - a)
                System.out.println("Valor intermedio");
            else 
                System.out.println("Más próximo a extremo derecho.");
        }
        else 
            System.out.println("El supuesto central no está entre los límites.");

        sc.close();
    }

    /*
     * Lee un entero de la entrada estándar mostrando primero
     * el mensaje que se pasa como parámetro
     */
    public static long leerEntero(String promt) {
        long result;
        System.out.print(promt);
        result = Long.parseLong(sc.nextLine());
        return result;
    }
}