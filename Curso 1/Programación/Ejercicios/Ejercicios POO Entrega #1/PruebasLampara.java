/*
 * Este es un módulo de pruebas que sirve para testear la clase Lampara
 * 
 * @author Hugo
 * @version 1.0
 * @date 27 de enero de 2023
 */

import Lampara.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PruebasLampara  {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        Lampara l1 = new Lampara();
        int opcion;
        l1.mostrar();
        testObjeto(l1);

        do {
            mostrarOpciones();
            System.out.print("Opción:\n-> ");
            opcion = Integer.parseInt(lector.readLine());

            switch(opcion) {
                case 1 -> {   
                    System.out.print("Introduce un voltaje: ");
                    l1.setVoltaje(Double.parseDouble(lector.readLine()));
                }
                case 2 -> l1.encender();
                case 3 -> l1.apagar();
                case 4 -> l1.mostrar();
            }

        }
        while(opcion != 0);
    }

    public static void mostrarOpciones() {
        System.out.println("0. Salir.");
        System.out.println("1. Cambiar voltaje");
        System.out.println("2. Encender");
        System.out.println("3. Apagar.");
        System.out.println("4. Mostrar.");
    }

    public static void testObjeto(Lampara lamp) {
        System.out.println("**********   PRUEBAS MÉTODOS  ***********");
        lamp.getIntensidad();
        lamp.getVoltaje();
        lamp.estaEncedida();

        lamp.encender();
        lamp.apagar();

        lamp.setIntensidad(5.4);
        lamp.setIntensidad(66);
        lamp.setVoltaje(16.4);
        System.out.println("*****************************************");
    }
}
