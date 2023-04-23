package estructuras_control.de_salto;

import java.util.Scanner;

/**
 * Este ejemplo muestra un uso básico de la sentencia break
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class SentenciaBreak {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        int[] elementos = { 1, 0, 4, 5, 6, 7, 8, 9, 10, 22, 11 };
        System.out.print("Introduce un entero: ");
        int target = lector.nextInt();

        int indice = 0;
        boolean encontrado = false;

        while (indice < elementos.length) {
            if (elementos[indice] == target) {
                encontrado = true;
                break;
            }
            else
                ++indice;

        }

        if (encontrado)
            System.out.println("El elemento se ha encontrado en la posición: " + (indice - 1));
        else
            System.out.println("El elemento no existe...");
    }
}
