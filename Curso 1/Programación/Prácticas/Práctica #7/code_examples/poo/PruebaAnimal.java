package poo;

import java.util.LinkedList;
import java.util.List;

public class PruebaAnimal {
    public static void main(String[] args) {
        List<Animal> animales = new LinkedList<>();

        animales.add(new Gato("Catmander"));
        animales.add(new Perro("Gumball"));
        animales.add(new Persona("Pedro"));

        mostrarAnimales(animales);
    }

    public static void mostrarAnimales(List<Animal> lista) {
        lista.forEach(Animal::presentar);
    }
}
