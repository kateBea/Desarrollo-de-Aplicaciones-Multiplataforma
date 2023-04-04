package poo;

import poo.hipodromo.Caballo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.util.Random;

public class PracticaHipodromo {
    private static final Random rand = new Random();
    private static final int LIMITE_CABALLOS = 5;
    private static final int META = 700;
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader reader = new BufferedReader(input);
    private static LinkedList<Caballo> caballos;

    private static int[] tramos = { 50, 60, 70, 80 };

    public static void main(String[] args) {
        inicializarCaballos();
        mostrarCaballos();

        int apuesta = leerPuesta();
        int indiceGanador = -1;
        System.out.println("\nCOMIENZA LA CARRERA\n");
        updateRecorrido();
        
        while (!caballos.isEmpty() && indiceGanador == -1) {
            System.out.println();
            mostrarRecorridoCaballos();
            
            int index = 0; 
            int valorMaximo = 0;

            while (index < caballos.size()) {
                // El que alcance primero la meta tendrá más metros recorridos por encima 
                // de META metros

                // buscamos el máximo ya que los caballos no están guardados siguiendo un orden
                // y el primero en alcanzar más o igual que META metros no necesariamente
                // se encuentra antes en la lista
                if (caballos.get(index).getRecorrido() >= META && valorMaximo < caballos.get(index).getRecorrido()) {
                    indiceGanador = index;
                    valorMaximo = caballos.get(index).getRecorrido();
                }
                
                ++index;
            }
            
            if (indiceGanador == -1) {
                updateRecorrido();
                enterDown();
            }
        }

        System.out.println("\nFIN DE LA CARRERA");
        System.out.printf("\nEl ganador es %s con el dorsal %d\n", caballos.get(indiceGanador).getNombre(), caballos.get(indiceGanador).getDorsal());

        if (apuesta == caballos.get(indiceGanador).getDorsal())
            System.out.printf("\n¡Enorabuena, ha ganado su apuesta!\n", caballos.get(indiceGanador).getDorsal());
        else 
            System.out.printf("\nLo sentimos, no ha ganado su apuesta. Vuelva a intentarlo\n", caballos.get(indiceGanador).getDorsal());
    }

    public static void inicializarCaballos() {
        caballos = new LinkedList<>();
        Caballo[] temp = new Caballo[]{
            new Caballo("Rocinante", 1),
            new Caballo("Babieca", 2),
            new Caballo("Rufio", 3),
            new Caballo("Perla", 4),
            new Caballo("Rosado",5)
        };

        for (Caballo item : temp)
            caballos.add(item);
    }

    public static void mostrarCaballos() {
        System.out.println("Los caballos participantes son:");
        for (Caballo item : caballos)
            System.out.printf("%s con el dorsal %d\n", item.getNombre(), item.getDorsal());

        System.out.println();
    }

    public static void mostrarRecorridoCaballos() {
        System.out.println("Posición en la carrera de los caballos de primero a último");            
        for (int index = 0; index < caballos.size(); ++index) {
            if (probabilidad(15) == 0) {
                System.out.printf("ATENCIÓN CAÍDA: %s con el dorsal %d se ha caído\n", caballos.get(index).getNombre(), caballos.get(index).getDorsal());
                caballos.remove(index);
            }
            else 
                System.out.printf("%s con el dorsal %d (%d metros)\n", caballos.get(index).getNombre(), caballos.get(index).getDorsal(), caballos.get(index).getRecorrido());
        }

        System.out.println("\n");
    }

    public static void updateRecorrido() {
        for (int index = 0; index < caballos.size(); ++index)
            caballos.get(index).setRecorrido(caballos.get(index).getRecorrido() + tramos[rand.nextInt(tramos.length)]);
    }

    /*
     * Retorna 0 con una probabilidad de 1/prob
     */
    public static int probabilidad(int prob) {
        int[] array = new int[prob * caballos.size()];

        Arrays.fill(array, 1);
        array[rand.nextInt(array.length)] = 0;


        return array[rand.nextInt(array.length)];
    }

    public static void enterDown() {
        try {
            System.out.print("Pulse ENTER para continuar");
            reader.readLine();
        } 
        catch (IOException e) {

        }
    }

    public static int leerPuesta() {
        int resultado = -1;
        do {
            try {
                System.out.print("La carrera comenzará cuando apueste por un caballo: ");
                resultado = Integer.parseInt(reader.readLine());

                if (resultado < 1 || resultado > LIMITE_CABALLOS) {
                    System.out.println("Valor de dorsal inválido");
                    resultado = -1;
                }
            } 
            catch (NumberFormatException | IOException e) {
                System.out.println("Error de excepción al leer la apuesta");
            }
        }
        while (resultado == -1);

        return resultado;
    }
}