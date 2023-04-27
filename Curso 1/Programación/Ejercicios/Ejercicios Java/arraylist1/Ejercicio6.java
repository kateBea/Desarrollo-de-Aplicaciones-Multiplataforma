package arraylist1;

/* 
 * Este programa lee de la entrada de datos para una cantidad
 * determinada de luchadores, su peso en gramos y su altura y los muestra
 * por pantalla.
 * 
 * @author Hugo
 * @version 1.0
 * @date 24 de enero de 2023
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio6 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    // representa los datos de un luchador
    // Se ha implementado únicamente lo necesario
    private static class Luchador {
        // representa gramos por kilogramos
        private static final float GRAMOS_A_KILO = 1000;
        // representa centímetros por metro 
        private static final float CENTIMETRO_A_METRO = 100;
        // peso en kilogramos
        private float m_Peso;
        // altura en metros
        private float m_Altura;

        public Luchador() {
            m_Peso = 0;
            m_Altura = 0;
        }

        /* GETTERS */

        public void mostrar() {
            System.out.println("Peso: " + m_Peso + " kG.");
            System.out.println("Altura: " + m_Altura + " metros.");
            System.out.println("-------------------");
        }

        /* SETTERS */

        // retorna un luchador para poder utilizar con el método add
        // de la clase ArrayList, ver referencia más abajo
        public Luchador leerDatos() throws IOException {
            // se asume que se leen dos datos por líne
            // el primero es un decimal representando un peso en gramos
            // y el segundo es un decimal que representa la altura en centímetros
            String[] values =  lector.readLine().trim().split(" ");

            m_Peso = Float.parseFloat(values[0]) / GRAMOS_A_KILO;
            m_Altura = Float.parseFloat(values[1]) / CENTIMETRO_A_METRO;

            return this;
        }
    }

    public static void main(String[] args) throws IOException {
        int totalLuchadores;
        ArrayList<Luchador> luchadores;

        do {
            System.out.print("Introduce un total de luchadores [sólo valores posictivos o cero]: ");
            totalLuchadores = Integer.parseInt(lector.readLine());
        }
        while(totalLuchadores < 0);

        luchadores = leerLuchadores(totalLuchadores);
        mostrarLuchadores(luchadores);
    }

    public static ArrayList<Luchador> leerLuchadores(int total) throws IOException {
        ArrayList<Luchador> resultado = new ArrayList<Luchador>();

        for (int i = 0; i < total; ++i)
            resultado.add(new Luchador().leerDatos());

        return resultado;
    }

    public static void mostrarLuchadores(ArrayList<Luchador> luchadores) {
        for (Luchador item : luchadores) 
            item.mostrar();
    }
}