package poo;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import poo.zoo.Animal;
import poo.zoo.Gato;
import poo.zoo.Perro;
import poo.zoo.Gato.PelajeType;
import poo.zoo.Pajaro;

public class EjerVeterinario {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);
    public static void main(String[] args) {
        final int DIAS_ATENCION = 3;
        boolean acabar;
        int userInput;
        ArrayList<Animal> animales = setupAnimales();
        ArrayList<Animal> enfermos = new ArrayList<>();
        ArrayList<Animal> sanos = new ArrayList<>();

        enfermos.add(animales.get(0));
        enfermos.add(animales.get(3));
        enfermos.add(animales.get(6));

        sanos.add(animales.get(1));
        sanos.add(animales.get(2));
        sanos.add(animales.get(4));

        sanos.add(animales.get(5));
        sanos.add(animales.get(7));
        sanos.add(animales.get(8));

        // dias semana
        for (int dia = 1; dia <= DIAS_ATENCION; ++dia) {
            System.out.println("DIA " + dia + '\n');
            acabar = false;
            while (!acabar && enfermos.size() > 0) {
                mostrarAnimales(enfermos, "Animales enfermos");
                System.out.printf("¿Qué animal se ha recuperado ya? (1 - %d) (-1: ninguno) -> ", enfermos.size());
                userInput = getUserInput();

                acabar = userInput == -1;
                
                try {
                    if (!acabar) {
                        if (!sanos.contains(enfermos.get(userInput - 1)))
                            sanos.add(enfermos.get(userInput - 1));
    
                        enfermos.remove(userInput - 1);
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Por favor, introduzca un índice válido...");
                }
            }

            acabar = false;
            while (!acabar && sanos.size() > 0) {
                mostrarAnimales(sanos, "Animales sanos");
                System.out.printf("¿Qué animal ha enfermado? (1 - %d) (-1: ninguno) -> ", sanos.size());
                userInput = getUserInput();

                acabar = userInput == -1;

                try {
                    if (!acabar) {
                        if (!enfermos.contains(sanos.get(userInput - 1)))
                            enfermos.add(sanos.get(userInput - 1));
                            
                        sanos.remove(userInput - 1);
                    }
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Por favor, introduzca un índice válido...");
                }
            }


        }
        
    }

    public static ArrayList<Animal> setupAnimales() {
        ArrayList<Animal> resultado = new ArrayList<>();

        resultado.add(new Perro("Harold", "Husky", 5));
        resultado.add(new Perro("Carter", "Buldog", 3));
        resultado.add(new Perro("Kitty", "Chihuahua", 1));

        resultado.add(new Gato("El Gato Con Botas", PelajeType.MEDIANO, 2));
        resultado.add(new Gato("Cinderrella", PelajeType.LARGO, 2));
        resultado.add(new Gato("Turner", PelajeType.CORTO, 4));

        resultado.add(new Pajaro("Hyp", "azul", 2));
        resultado.add(new Pajaro("Kinky", "verde", 2));
        resultado.add(new Pajaro("Kitsune", "cyan", 3));

        return resultado;
    }

    public static void mostrarAnimales(ArrayList<Animal> animales, String header) {
        System.out.println(header);
        int indice = 1;
        for (Animal animal : animales) 
            System.out.println((indice++) + ".- " + animal.getNombre());

        System.out.println();
    }

    public static int getUserInput() {
        int userInput;
        try {
            userInput = Integer.parseInt(reader.readLine());
        } 
        catch (NumberFormatException | IOException e) {
            userInput = -1;
            e.printStackTrace();
        }

        return userInput;
    }

}