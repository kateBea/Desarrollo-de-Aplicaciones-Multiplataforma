package coleccion8;
 
/*
 * Este programa crea un diccionario de traducción del Inglés al castellano
 * utilizando la interfaz de Collections
 * 
 * @author Hugo
 * @version 1.0
 * @date 21 de enero de 2023
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio1 {
    private static final InputStreamReader input = new InputStreamReader(System.in);
    private static final BufferedReader lector = new BufferedReader(input);

    public static void main(String[] args) throws IOException {
        // para el propósito de este ejercicio se leen
        // los datos de la terminal, lo cual resulta incómodo para rellenar 
        // los datos necesarios para este diccionario, sería más ideal leer de un fichero regular

        TreeMap<String, String> diccionario = leerDiccionario();
        imprimirDiccionario(diccionario);


    }

    /*
     * Este método lee un par de cadenas de la entrada de datos. La primera
     * cadena representa una expresión en castellano y la segunda representa
     * su correspondiente traducción al español.
     * 
     * @param None
     * @return TreeMap<> Un objeto map conteniendo para cada expresión su traducción
     * @author Hugo
     */
    public static TreeMap<String, String> leerDiccionario() throws IOException {
        TreeMap<String, String> resultado = new TreeMap<>();
        String expresionEsp;
        String expresionIng;
        int totalExpresiones;

        System.out.print("Cuántas frases o palabras vas a introducir? ");
        do {
            totalExpresiones = Integer.parseInt(lector.readLine());
            System.out.print((totalExpresiones < 0 ? "Introduzca un valor positivo o cero: " : "\n"));
        }
        while (totalExpresiones < 0);

        for (int i = 0; i < totalExpresiones; ++i) {
            System.out.print("Introduzca una palabra o frase on Español:           ");
            expresionEsp = lector.readLine().trim().toLowerCase();
            System.out.print("Introduzca su corrrespondiente traducción al Inglés: ");
            expresionIng = lector.readLine().trim().toLowerCase();

            resultado.put(expresionEsp, expresionIng);
            System.out.print("\n");
        }

        return resultado;
    }

    /*
     * Este método muestra por la salida de datos el contenido de un Map<> 
     * 
     * @param diccionario la estructura Map<> que contiene los datos a ser impresos
     * @return void
     * @author Hugo
     */
    public static void imprimirDiccionario(Map<String, String> diccionario) {
        System.out.println("****** Contenido ******");
        for (Map.Entry<String, String> par : diccionario.entrySet()) {
            System.out.print("La expresión en Castellano [ " + par.getKey() + " ] ");
            System.out.println("en Inglés es [ " + par.getValue() + " ]");
        }
    }
}