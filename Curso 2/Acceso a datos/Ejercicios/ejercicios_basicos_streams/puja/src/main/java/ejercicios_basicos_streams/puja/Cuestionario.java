package ejercicios_basicos_streams.puja;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cuestionario {
    private static List<Subasta> subastas;
    private static class Cuestion1 implements Runnable {

        @Override
        public void run() {
            // Cuenta los usuarios que tienen cuenta de correo
            // en Gmail. Muestra el resultado en la consola.
            System.out.println("\nCuestión 1:");

            System.out.println("Unknown");
        }
    }

    private static class Cuestion2 implements Runnable {

        @Override
        public void run() {
            // Mostrar por la consola los nombres de usuarios que
            // sean propietarios de subastas ordenados por orden alfabético inverso.
            System.out.println("\nCuestión 2:");

            subastas.stream().
                    map(Subasta::getPropietario).
                    sorted(Comparator.comparing(Usuario::getNombre).reversed()).
                    forEach(System.out::println);
        }
    }

    private static class Cuestion3 implements Runnable {

        @Override
        public void run() {
            // Mostrar por la consola los nombres de los productos cuyas
            // subastas hayan recibido alguna puja ordenados alfabéticamente.
            System.out.println("\nCuestión 3:");

            subastas.stream().
                    filter(subasta -> !subasta.getPujas().isEmpty()).
                    map(Subasta::getNombreProducto).
                    sorted(String::compareTo).
                    toList().
                    forEach(System.out::println);

        }
    }

    private static class Cuestion4 implements Runnable {

        @Override
        public void run() {
            // Mostrar por la consola el nombre de los productos de
            // aquellas subastas que hayan recibido pujas superiores a 50 euros
            System.out.println("\nCuestión 4:");

            subastas.stream().
                    filter(subasta -> subasta.getPujas().stream().
                            anyMatch(puja -> puja.getCantidad() > 50.0)).
                    map(Subasta::getNombreProducto).
                    toList().
                    forEach(System.out::println);
        }
    }

    private static class Cuestion5 implements Runnable {

        @Override
        public void run() {
            // Consultar si hay usuarios que hayan ganado alguna subasta
            // y que sean propietarios de subastas
            System.out.println("\nCuestión 5:");

            final boolean existe = ! (subastas.stream().
                    filter(subasta -> !subasta.isAbierta()).
                    map(Subasta::getPropietario).
                    distinct().toList().isEmpty());

            System.out.println("¿Existen usuarios ganadores de subastas que son propietarios de otras? " + existe);
        }
    }

    private static class Cuestion6 implements Runnable {

        @Override
        public void run() {
            // Crea un conjunto vacío de pujas, añade a ese conjunto
            // todas las pujas que se hayan realizado en las subastas.
            System.out.println("\nCuestión 6:");

            Set<Puja> pujas;

            pujas = subastas.stream().flatMap(sub -> sub.getPujas().stream()).collect(Collectors.toSet());

            pujas.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        inicializarDatos();

        List<Runnable> cuestiones = Arrays.asList(new Cuestion1(), new Cuestion2(),
                new Cuestion3(), new Cuestion4(), new Cuestion5(), new Cuestion6());

        for (Runnable task : cuestiones) {
            task.run();
        }
    }

    public static void pujar(Usuario pujador, Subasta subasta, double cantidad) {
        System.out.println(pujador.getNombre() + " puja por " + subasta.getNombreProducto() + " con una cuantía de " + cantidad + ". Aceptada: " + subasta.pujar(pujador, cantidad));
    }

    private static void inicializarDatos() {
        Usuario juan = new Usuario("Juan", 100);
        Usuario pedro = new Usuario("Pedro", 150);
        Usuario enrique = new Usuario("Enrique", 300);
        Usuario ramon = new Usuario("Ramón", 250);

        Subasta sub1 = new Subasta("Teléfono Móvil", juan);
        Subasta sub2 = new Subasta("Televisor LG", ramon);
        Subasta sub3 = new Subasta("MacBook PRO", pedro);
        Subasta sub4 = new Subasta("Trompeta", enrique);

        pujar(juan, sub2, 100);
        sub1.ejecutar();

        subastas = Arrays.asList(sub1, sub2, sub3, sub4);
    }
}
