package Ejercicio3;

import Ejercicio1.Localidad;

public class PruebaDensidadPoblacion {
    public static void main(String[] args) {
        Localidad loc1 = new Localidad("Torrejón", "Madrid", 23877, 144.5f, 123.6f, 1.44f);
        Localidad loc2 = new Localidad("Alcalá de Henares", "Madrid", 20345, 136.5f, 100.6f, 3.44f);
        Localidad loc3 = new Localidad("Madrid", "Madrid", 34752, 234.5f, 256.6f, 4.44f);

        loc1.mostrar();
        loc2.mostrar();
        loc3.mostrar();

        System.out.println("Densidad de población de " + loc1.getNombre() + ": " + loc1.densidadDePoblacion());
        System.out.println("Densidad de población de " + loc2.getNombre() + ": " + loc2.densidadDePoblacion());
        System.out.println("Densidad de población de " + loc3.getNombre() + ": " + loc3.densidadDePoblacion());
    }
}
