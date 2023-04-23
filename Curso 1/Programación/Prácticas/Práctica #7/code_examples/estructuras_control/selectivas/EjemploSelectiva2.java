package estructuras_control.selectivas;

import java.util.Scanner;

/**
 * Este ejemplo muestra un uso básico la sentencia if
 * para determinar si el usuario es mayor o menor de edad
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploSelectiva2 {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        final int MAYOR_DE_EDAD = 18;

        System.out.print("Mi edad: ");
        int miEdad = lector.nextInt();
        if (miEdad < MAYOR_DE_EDAD)
            System.out.println("Todavía soy mayor de edad :(");
        else
            System.out.println("¡Ya soy mayor de edad! Por fin :))");

        lector.close();
    }
}
