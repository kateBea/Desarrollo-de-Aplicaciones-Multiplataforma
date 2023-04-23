package estructuras_control.repetitivas;

import java.util.Scanner;

/**
 * Escribe los que el usuario ha entrado, si es menor
 * que uno se vuelve a solicitar un número
 * Creado por Hugo Pelayo
 * 23 abril de 2023
 * */
public class BucleDoWhile {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        int numero;

        do {
            System.out.print("Entre un entero mayor que 1: ");
            numero = Integer.parseInt(lector.nextLine());
        }
        while (numero <= 1);

        System.out.println("Usted ha introducido el número: " + numero);
    }
}
