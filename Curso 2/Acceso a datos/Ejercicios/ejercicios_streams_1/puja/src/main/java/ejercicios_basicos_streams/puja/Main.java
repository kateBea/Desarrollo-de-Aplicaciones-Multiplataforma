package ejercicios_basicos_streams.puja;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Usuario juan = new Usuario("Juan", 100);
        Usuario pedro = new Usuario("Pedro", 150);
        Usuario enrique = new Usuario("Enrique", 300);

        Subasta sub = new Subasta("Teléfono Móvil", juan);

        System.out.println("Aceptada puja de Pedro por 100: " + sub.pujar(pedro, 100));

        sub.getPujaMayor().ifPresent(System.out::println);
        System.out.println("Aceptada puja de enrique de 50: " + sub.pujar(enrique, 50));
        System.out.println("Ejecutada subasta: " + sub.ejecutar());
        Arrays.asList(juan, pedro, enrique).forEach(System.out::println);
    }
}