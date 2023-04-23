package estructuras_control.selectivas;

import java.util.Scanner;

public class EjemploSelectiva3 {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce un entero: ");
        int entero = lector.nextInt();

        if (entero > 0)
            System.out.println("El entero es un valor positivo");
        else if (entero < 0)
            System.out.println("El entero es un valor negativo");
        else
            System.out.println("El entero es un valor nulo");

        lector.close();
    }
}
