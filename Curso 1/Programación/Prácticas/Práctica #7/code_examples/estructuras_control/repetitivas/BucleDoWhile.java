package estructuras_control.repetitivas;

import java.util.Scanner;

/**
 * Este ejemplo muestra un uso básico del bucle do-while
 * solicitando un número al usuario hasta que este introduzca un valor
 * mayor que 1
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
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
