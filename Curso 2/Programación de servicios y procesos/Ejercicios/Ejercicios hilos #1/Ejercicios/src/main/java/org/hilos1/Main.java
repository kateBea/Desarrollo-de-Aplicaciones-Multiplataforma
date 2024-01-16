package org.hilos1;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<Runner> ejercicios = new ArrayList<>();

        ejercicios.add(new Ejercicio1());

        for (Runner ejercicio : ejercicios) {
            ejercicio.run();
        }
    }
}