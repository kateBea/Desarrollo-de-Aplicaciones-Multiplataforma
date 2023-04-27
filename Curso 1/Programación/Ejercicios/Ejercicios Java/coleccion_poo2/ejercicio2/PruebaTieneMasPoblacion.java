package coleccion_poo2.ejercicio2;

import coleccion_poo2.ejercicio1.Localidad;

public class PruebaTieneMasPoblacion {
    public static void main(String[] args) {
        Localidad loc1 = new Localidad("Torrejón", "Madrid", 23877, 144.5f, 123.6f, 1.44f);
        Localidad loc2 = new Localidad("Alcalá de Henares", "Madrid", 20345, 136.5f, 100.6f, 3.44f);
        loc1.mostrar();
        loc2.mostrar();

        if (loc1.tieneMasPoblacion(loc2))
            System.out.println(loc1.getNombre() + " tiene más población que " + loc2.getNombre());
        else 
        System.out.println(loc2.getNombre() + " tiene más población que " + loc1.getNombre());
    }
}
