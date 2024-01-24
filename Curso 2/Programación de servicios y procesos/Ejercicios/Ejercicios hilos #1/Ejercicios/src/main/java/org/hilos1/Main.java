package org.hilos1;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<Runner> ejercicios = new ArrayList<>();

        //ejercicios.add(new Ejercicio1());
        //ejercicios.add(new Ejercicio2());
        //ejercicios.add(new Ejercicio3());
        //ejercicios.add(new Ejercicio4());
        //ejercicios.add(new Ejercicio5());
        //ejercicios.add(new Ejercicio6());
        ejercicios.add(new Ejercicio7());

        for (Runner ejercicio : ejercicios) {
            ejercicio.run();
        }
    }
}