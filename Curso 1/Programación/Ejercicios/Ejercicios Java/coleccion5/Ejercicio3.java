package coleccion5;

/*
 * Título: Ejercicio 3
 * Algoritmo: Leer una cadena y una letra. Escribir las posiciones de la letra en la cadena
 * Autor: Hugo Pelayo:
 * Fecha: 24.11.2022
 */

 import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        String userInput;
        char caracter;
        int[] posiciones;
        int indexPosiciones;
        int numberApariciones;

        System.out.print("Introduce una cadena de caracteres por favor: ");
        userInput = reader.readLine();
        System.out.print("Introduzca un carácter por favor: ");
        caracter = reader.readLine().charAt(0);        

        // ya que usamos arrays estáticos, en el peor de los casos
        // el carácter se repetiá en todas las posiciones del String
        posiciones = new int[userInput.length()];
        indexPosiciones = 0;

        // Inicializamos todas las posiciones a -1 porque asumimos
        // que el carácter no aparece en el String
        for (int index = 0; index < posiciones.length; ++index)
            posiciones[index] = -1;

        indexPosiciones = 0;
        numberApariciones = 0;
        for (int index = 0; index < userInput.length(); ++index) {
            if (userInput.charAt(index) == caracter) {
                posiciones[indexPosiciones++] = index;
                numberApariciones++;
            }
        }
        
        if (numberApariciones == 1)
            System.out.print("El carácter '" + caracter + "' aparece " + numberApariciones + " vez en la posición: ");
        else 
            System.out.print("El carácter '" + caracter + "' aparece " + numberApariciones + " veces en las posiciones: ");

        boolean first = true;
        int indice = 0;
        while (indice < posiciones.length && posiciones[indice] != -1) {
            if (first) {
                first = false;
                System.out.print(posiciones[indice]);
            }
            else 
                System.out.print(", " + posiciones[indice]);

            ++indice;
        }

        System.out.println();
    }
}
