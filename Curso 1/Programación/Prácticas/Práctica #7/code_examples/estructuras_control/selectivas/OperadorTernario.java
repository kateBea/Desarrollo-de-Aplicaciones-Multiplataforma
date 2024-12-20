package estructuras_control.selectivas;

import java.util.Scanner;

/**
 * Este ejemplo muestra un uso básico operador ternario
 * para mostrar por pantalla si la edad que el usuario ha introducido
 * corresponde a la mayoría de edad o no
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class OperadorTernario {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        final int MAYOR_DE_EDAD = 18;
        String siMayorEdad = "¡Ya soy mayor de edad! Por fin :))";
        String noMayorEdad = "Todavía soy mayor de edad :(";

        System.out.print("Mi edad: ");
        int miEdad = lector.nextInt();

        System.out.println(miEdad < MAYOR_DE_EDAD ? noMayorEdad : siMayorEdad);
        lector.close();
    }
}