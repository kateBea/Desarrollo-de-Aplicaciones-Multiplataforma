/*
 * Título: Ejercicio 5
 * Algoritmo: Censurar un String
 * Fecha: 16.11.2022
 * Autor: Hugo Pelayo
 */


public class Ejercicio5 {
    public static void main(String[] args) {
        String original = new String("El dipuTAdo dijo: el muy hijo de puta está imPUtado por la amputación de una PUta oreja");
        String censurado = new String("");
        String palabraCensurada = "puta";

        for (String subStr : original.split(" ")) {
            if (subStr.equalsIgnoreCase(palabraCensurada))
            censurado = censurado + (new String("*").repeat(palabraCensurada.length()) + " ");
            else
                censurado = censurado + subStr + " ";
        }

        censurado.trim();
        System.out.println("Frase censurada: " + censurado);
    }    

}