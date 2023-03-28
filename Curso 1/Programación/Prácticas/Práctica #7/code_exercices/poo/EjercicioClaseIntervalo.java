package poo;

import poo.math.Intervalo;
import poo.math.InvalidRangeException;                                                           

public class EjercicioClaseIntervalo {
    public static void main(String[] args) {
        Intervalo intervalo1 = new Intervalo(1.2, 4.3);
        Intervalo intervalo2 = new Intervalo(2.3, 4.6);
        Intervalo intervalo3 = new Intervalo(2.3, 7.2);

        System.out.println("Mostramos nuestro intervalo");
        intervalo1.mostrar();

        System.out.println();
        System.out.println("Mostramos longitud intervalo");
        System.out.println("Longitud: " + intervalo1.longitud());

        System.out.println();
        System.out.println("Cambiamos intervalo intervalo con excepción para valor " + -1.4);
        try {
            intervalo1.setCotaSuperior(-1.4);
        }
        catch (InvalidRangeException ir) {
            System.out.println(ir.getMessage());
        }

        System.out.println();
        System.out.println("Cambiamos intervalo intervalo sin excepción");
        intervalo1.setCotaSuperior(5.4);

        System.out.println();
        System.out.print("Mostramos 4 porciones para intervalo ");
        intervalo1.mostrar();
        for (Intervalo elem : intervalo1.troceado(4))
            elem.mostrar();

        System.out.println();
        System.out.println("Inclusiones");

        System.out.print(intervalo1.toString());
        System.out.println(" incluye intervalo " + (intervalo2.toString()) + "? " + intervalo1.incluye(intervalo2));
        System.out.print(intervalo1.toString());
        System.out.println(" incluye intervalo " + (intervalo3.toString()) + "? " + intervalo1.incluye(intervalo3));
        System.out.print(intervalo1.toString());
        System.out.println(" incluye punto " + "3.4"+ "? " + intervalo1.incluye(3.4));

    }
}